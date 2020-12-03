package com.software.no_appearance_back.bl;

import com.software.no_appearance_back.dao.*;
import com.software.no_appearance_back.domain.*;
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

    public List<MatchEntity> listarMatchesPorIdCliente(int idCliente) {
        List<MatchEntity> matchEntityList= new ArrayList<>();
        crearMatch(idCliente);
        matchEntityList = matchRepository.findMatchEntityByEstadoAndIdCliente1OrIdCliente2(1, idCliente,idCliente);
        return matchEntityList;
    }

    private void crearMatch(int idCliente) {
        List<MatchEntity> matchEntityList= new ArrayList<>();
        // sacar las cliente_subcategorias del cliente
        List<ClienteSubcategoriaEntity> subcategoriasCliente=  clienteSubcategoriaRepository.findAllByIdCliente(idCliente);

        // guardar las cliente_subcategorias que coincidadn con las cliente_subcategorias del cliente
        List<ClienteSubcategoriaEntity> subcategoriasClientesGeneales=  clienteSubcategoriaRepository.findAll();

        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setIdCliente1(idCliente);
        matchEntity.setEstado(1);


        for (int i = 0; i < subcategoriasCliente.size(); i++) {
            for (int j = 0; j < subcategoriasClientesGeneales.size(); j++) {
                int idCliente2 =subcategoriasClientesGeneales.get(j).getIdCliente();

                boolean existematchsubcategoriaprevia = (matchSubcategoriaRepository.findMatchSubcategoriaByIdClientes(idCliente,idCliente2)!=null);
                if (!existematchsubcategoriaprevia){
                    boolean existematchprevio = (matchRepository.findMatchEntityByIdCliente1OrIdCliente2(idCliente,idCliente2)!=null);
                    if (!existematchprevio){
                        boolean coincidencia = subcategoriasCliente.get(i).getIdSubcategoria() == subcategoriasClientesGeneales.get(j).getIdSubcategoria();
                        if(coincidencia){
                            matchEntity.setIdCliente2(idCliente);
                            matchEntity = transaccion(matchEntity);
                            matchRepository.save(matchEntity);
                        }
                    } // if !existematchprevio
                    guardarMatchSubcategoria(idCliente, idCliente2,subcategoriasCliente.get(i).getIdSubcategoria());
                }

            } // for j
        } // for i
    }

    private void guardarMatchSubcategoria(int idCliente, int idCliente2, int idSubcategoria) {
        int idMatch = matchRepository.findMatchEntityByIdCliente1OrIdCliente2(idCliente,idCliente2).getIdMatch();
        MatchSubcategoriaEntity matchSubcategoriaEntity= new MatchSubcategoriaEntity();
        matchSubcategoriaEntity.setIdMatch(idMatch);
        matchSubcategoriaEntity.setIdSubcategoria(idSubcategoria);
        matchSubcategoriaRepository.save(matchSubcategoriaEntity);
    }

    private MatchEntity transaccion(MatchEntity matchEntity) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        matchEntity.setTxId(0); // Id de la transaccion
        matchEntity.setTxHost("192.168.0.1"); // Direccion Ip
        matchEntity.setTxUser(0);
        matchEntity.setTxDate(new Timestamp(System.currentTimeMillis())); // Fecha Actual
        matchEntity.setTxUpdate(new Date(System.currentTimeMillis()));
        return matchEntity;
    }
}
