package com.software.no_appearance_back.bl;

import com.software.no_appearance_back.dao.ClienteRepository;
import com.software.no_appearance_back.domain.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;


@Service
public class ClienteBl {
    ClienteRepository clienteRepository;


    @Autowired
    public ClienteBl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public int getID(ClienteEntity clienteEntity) {
        ClienteEntity clienteEntity1 = clienteRepository.findClienteEntityByCorreoAndContrasena(clienteEntity.getCorreo(), clienteEntity.getContrasena());
        int id = clienteEntity1.getIdCliente();
        return id;
    }


    public void registrarCliente(ClienteEntity clienteEntity) {
        clienteEntity = transaccion(clienteEntity);
        clienteEntity.setNacimiento(new Date(System.currentTimeMillis()));
        clienteRepository.save(clienteEntity);
    }

    private ClienteEntity transaccion(ClienteEntity clienteEntity) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        clienteEntity.setTxId(0); // Id de la transaccion
        clienteEntity.setTxHost("192.168.0.1"); // Direccion Ip
        clienteEntity.setTxUser(0);
        clienteEntity.setTxDate(new Timestamp(System.currentTimeMillis())); // Fecha Actual
        clienteEntity.setTxUpdate(new Date(System.currentTimeMillis()));

        return clienteEntity;
    }


    public boolean checkLogin(String correo, String contrasena) {

        ClienteEntity clienteEntity = clienteRepository.findClienteEntityByCorreo(correo);
        if (clienteEntity!=null)
        {
            return clienteEntity.getContrasena().equals(contrasena);
        }else{
            return false;
        }
    }

}
