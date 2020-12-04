package com.software.no_appearance_back.bl;

import com.software.no_appearance_back.dao.*;
import com.software.no_appearance_back.domain.*;
import com.software.no_appearance_back.model.Match;
import com.software.no_appearance_back.model.MatchSubcategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class MatchBl {
    MatchRepository matchRepository;
    MatchSubcategoriaRepository matchSubcategoriaRepository;
    SubcategoriaRepository subcategoriaRepository;
    ClienteSubcategoriaRepository clienteSubcategoriaRepository;

    @Autowired
    public MatchBl(MatchRepository matchRepository, MatchSubcategoriaRepository matchSubcategoriaRepository, SubcategoriaRepository subcategoriaRepository, ClienteSubcategoriaRepository clienteSubcategoriaRepository) {
        this.matchRepository = matchRepository;
        this.matchSubcategoriaRepository = matchSubcategoriaRepository;
        this.subcategoriaRepository = subcategoriaRepository;
        this.clienteSubcategoriaRepository = clienteSubcategoriaRepository;
    }

    public List<Match> listarMatchesPorIdCliente(int idCliente) {
        List<MatchiEntity> matchEntityList= new ArrayList<>();
        crearMatch(idCliente);
        matchEntityList = matchRepository.findMatchEntityByEstadoAndIdCliente1OrIdCliente2(1, idCliente);
        List<Match> matchList = new ArrayList<>();
        String nameCliente = "";
        for (MatchiEntity m : matchEntityList) {
            if(idCliente == m.getIdCliente1())
                nameCliente = matchRepository.findNameByIdCliente(m.getIdCliente2(),idCliente);
            else
                nameCliente = matchRepository.findNameByIdCliente(m.getIdCliente1(),idCliente);
            Match match = new Match(m.getIdMatch(),m.getIdCliente1(),m.getIdCliente2(), nameCliente);
            matchList.add(match);
        }
        return matchList;
    }

    private void crearMatch(int idCliente) {
        List<MatchiEntity> matchEntityList= new ArrayList<>();
        // sacar las cliente_subcategorias del cliente
        List<ClienteSubcategoriaEntity> subcategoriasCliente=  clienteSubcategoriaRepository.findAllByIdCliente(idCliente);

        // guardar las cliente_subcategorias que coincidadn con las cliente_subcategorias del cliente
        List<ClienteSubcategoriaEntity> subcategoriasClientesGeneales=  clienteSubcategoriaRepository.findAll();

        MatchiEntity matchEntity = new MatchiEntity();
        matchEntity.setIdCliente1(idCliente);
        matchEntity.setEstado(1);

        for (int i = 0; i < subcategoriasCliente.size(); i++) {
            for (int j = 0; j < subcategoriasClientesGeneales.size(); j++) {
                int idCliente2 =subcategoriasClientesGeneales.get(j).getIdCliente();

                if(idCliente!=idCliente2)
                {
                    boolean existematchsubcategoriaprevia = (matchSubcategoriaRepository.findMatchSubcategoriaByIdClientes(idCliente,idCliente2,subcategoriasCliente.get(i).getIdSubcategoria())!=null);
                    if (!existematchsubcategoriaprevia){
                        boolean coincidencia = subcategoriasCliente.get(i).getIdSubcategoria() == subcategoriasClientesGeneales.get(j).getIdSubcategoria();
                        if(coincidencia){
                            boolean existematchprevio = (matchRepository.findMatchEntityByIdCliente1OrIdCliente2(idCliente,idCliente2)!=null);
                            if (!existematchprevio){
                                matchEntity.setIdCliente2(idCliente2);
                                matchEntity = transaccion(matchEntity);
                                matchRepository.save(matchEntity);
                            }
                            guardarMatchSubcategoria(idCliente, idCliente2,subcategoriasCliente.get(i).getIdSubcategoria());
                        }
                    }
                }

            } // for j
        } // for i
    }

    private void guardarMatchSubcategoria(int idCliente, int idCliente2, int idSubcategoria) {
        int idMatch = matchRepository.findMatchEntityByIdCliente1OrIdCliente2(idCliente,idCliente2).getIdMatch();
        MatchSubcategoriaEntity matchSubcategoriaEntity= new MatchSubcategoriaEntity();
        matchSubcategoriaEntity.setIdMatch(idMatch);
        matchSubcategoriaEntity.setIdSubcategoria(idSubcategoria);
        matchSubcategoriaEntity= transaccionMatchSubcategoriaEntity(matchSubcategoriaEntity);
        matchSubcategoriaRepository.save(matchSubcategoriaEntity);
    }

    private MatchSubcategoriaEntity transaccionMatchSubcategoriaEntity(MatchSubcategoriaEntity matchSubcategoriaEntity) {
        matchSubcategoriaEntity.setTxId(0); // Id de la transaccion
        matchSubcategoriaEntity.setTxHost("192.168.0.1"); // Direccion Ip
        matchSubcategoriaEntity.setTxUser(0);
        matchSubcategoriaEntity.setTxDate(new Timestamp(System.currentTimeMillis())); // Fecha Actual
        matchSubcategoriaEntity.setTxUpdate(new Date(System.currentTimeMillis()));
        return matchSubcategoriaEntity;
    }

    private MatchiEntity transaccion(MatchiEntity matchEntity) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        matchEntity.setTxId(0); // Id de la transaccion
        matchEntity.setTxHost("192.168.0.1"); // Direccion Ip
        matchEntity.setTxUser(0);
        matchEntity.setTxDate(new Timestamp(System.currentTimeMillis())); // Fecha Actual
        matchEntity.setTxUpdate(new Date(System.currentTimeMillis()));
        return matchEntity;
    }

    public List<MatchSubcategoria> matchDetallePorIdClientes(int idCliente1, int idCliente2) {
        List<MatchSubcategoriaEntity> matchSubcategoriaEntityList = new ArrayList<>();
        matchSubcategoriaEntityList = matchSubcategoriaRepository.findMatchSubcategoriaListByIdClientes(idCliente1,idCliente2);
        List<MatchSubcategoria> matchSubcategoriaList = new ArrayList<>();
        for (MatchSubcategoriaEntity ms:matchSubcategoriaEntityList) {
            SubcategoriaEntity sce = subcategoriaRepository.findByIdSubcategoria(ms.getIdSubcategoria());
            MatchSubcategoria matchSubcategoria = new MatchSubcategoria(ms.getMatchSubcategoria(), ms.getIdMatch(), ms.getIdSubcategoria(),sce.getSubcategoria(), sce.getFoto());
            matchSubcategoriaList.add(matchSubcategoria);
        }

        return matchSubcategoriaList;
    }


}








