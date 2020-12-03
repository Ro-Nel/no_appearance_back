package com.software.no_appearance_back.bl;

import com.software.no_appearance_back.dao.CategoriaRepository;
import com.software.no_appearance_back.dao.ClienteRepository;
import com.software.no_appearance_back.dao.ClienteSubcategoriaRepository;
import com.software.no_appearance_back.dao.SubcategoriaRepository;
import com.software.no_appearance_back.domain.CategoriaEntity;
import com.software.no_appearance_back.domain.ClienteEntity;
import com.software.no_appearance_back.domain.ClienteSubcategoriaEntity;
import com.software.no_appearance_back.domain.SubcategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class CategoriaBl {
    CategoriaRepository categoriaRepository;
    SubcategoriaRepository subcategoriaRepository;
    ClienteSubcategoriaRepository clienteSubcategoriaRepository;

    @Autowired
    public CategoriaBl(CategoriaRepository categoriaRepository, SubcategoriaRepository subcategoriaRepository, ClienteSubcategoriaRepository clienteSubcategoriaRepository) {
        this.categoriaRepository = categoriaRepository;
        this.subcategoriaRepository = subcategoriaRepository;
        this.clienteSubcategoriaRepository = clienteSubcategoriaRepository;
    }


    public List<CategoriaEntity> listarcategorias() {
        List<CategoriaEntity> categoriaEntityList= categoriaRepository.findAll();
        return categoriaEntityList;

    }


    public List<SubcategoriaEntity> listarSubcategoriasPorIdCategoria(int idCategoria) {
        List<SubcategoriaEntity> subcategoriaEntityList= subcategoriaRepository.findByIdCategoria(idCategoria);
        return subcategoriaEntityList;
    }


    public void clientesubcategoriaGuardar(List<ClienteSubcategoriaEntity> clienteSubcategoriaEntityList) {
        for (int i = 0; i < clienteSubcategoriaEntityList.size(); i++) {
            ClienteSubcategoriaEntity clienteSubcategoriaEntity = clienteSubcategoriaEntityList.get(i);
            clienteSubcategoriaEntity = transaccion(clienteSubcategoriaEntity);
            clienteSubcategoriaRepository.save(clienteSubcategoriaEntity);
        }
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

}
