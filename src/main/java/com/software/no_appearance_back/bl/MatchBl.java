package com.software.no_appearance_back.bl;

import com.software.no_appearance_back.dao.CategoriaRepository;
import com.software.no_appearance_back.dao.ClienteSubcategoriaRepository;
import com.software.no_appearance_back.dao.MatchRepository;
import com.software.no_appearance_back.dao.SubcategoriaRepository;
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
    SubcategoriaRepository subcategoriaRepository;
    ClienteSubcategoriaRepository clienteSubcategoriaRepository;

    @Autowired
    public MatchBl(MatchRepository matchRepository , SubcategoriaRepository subcategoriaRepository, ClienteSubcategoriaRepository clienteSubcategoriaRepository) {
        this.matchRepository = matchRepository;
        this.subcategoriaRepository = subcategoriaRepository;
        this.clienteSubcategoriaRepository = clienteSubcategoriaRepository;
    }



    private ClienteSubcategoriaEntity transaccion(ClienteSubcategoriaEntity clienteSubcategoriaEntity) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        clienteSubcategoriaEntity.setTxId(0); // Id de la transaccion
        clienteSubcategoriaEntity.setTxHost("192.168.0.1"); // Direccion Ip
        clienteSubcategoriaEntity.setTxUser(0);
        clienteSubcategoriaEntity.setTxDate(new Timestamp(System.currentTimeMillis())); // Fecha Actual
        clienteSubcategoriaEntity.setTxUpdate(new Date(System.currentTimeMillis()));
        return clienteSubcategoriaEntity;
    }

    public List<MatchEntity> listarMatchesPorIdCliente(int idCliente) {
        List<MatchEntity> matchEntityList= new ArrayList<>();
        matchEntityList.addAll(crearMatch(idCliente));
        //matchEntityList.addAll(matchRepository.findMatchEntityByEstadoAndIdCliente1OrIdCliente2(1, idCliente,idCliente));
        return matchEntityList;
    }
    private List<MatchEntity> crearMatch(int idCliente) {
        List<MatchEntity> matchEntityList= new ArrayList<>();
        // sacar las cliente_subcategorias del cliente
        List<ClienteSubcategoriaEntity> subcategoriasCliente=  clienteSubcategoriaRepository.findAllByIdCliente(idCliente);
        // contar cuantas son (ese es el 100)
        int total=  clienteSubcategoriaRepository.findCountByIdCliente(idCliente);
        // guardar las cliente_subcategorias que coincidadn con las cliente_subcategorias del cliente
        List<ClienteSubcategoriaEntity> subcategoriasClientesGeneales=  clienteSubcategoriaRepository.findAllByIdCliente(idCliente);


        // guardar las cliente_subcategorias que coincidadn con las subcategorias del cliente
        // sacar promedios y mostrar las mayores a 50%
        return matchEntityList;
    }
}
