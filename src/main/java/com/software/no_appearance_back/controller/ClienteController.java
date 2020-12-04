package com.software.no_appearance_back.controller;


import com.software.no_appearance_back.bl.ClienteBl;
import com.software.no_appearance_back.domain.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    ClienteBl clienteBl;

    @Autowired
    public ClienteController(ClienteBl clienteBl) {
        this.clienteBl = clienteBl;
    }


    @RequestMapping(value = "/registrarcliente", method = RequestMethod.POST)
    public ResponseEntity registrarCliente(@RequestBody ClienteEntity clienteEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
        clienteBl.registrarCliente(clienteEntity);
        return new ResponseEntity("Creado", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/logincliente", method = RequestMethod.POST)
    public ResponseEntity logincliente(@RequestBody ClienteEntity clienteEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
        if(clienteBl.checkLogin(clienteEntity.getCorreo(),clienteEntity.getContrasena())) {
            int idCliente = clienteBl.getID(clienteEntity);
            return new ResponseEntity(idCliente, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(-1, HttpStatus.ACCEPTED);
        }
    }
}
