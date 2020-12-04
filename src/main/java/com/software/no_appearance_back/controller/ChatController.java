package com.software.no_appearance_back.controller;


import com.software.no_appearance_back.bl.ChatBl;
import com.software.no_appearance_back.domain.ChatEntity;
import com.software.no_appearance_back.domain.MatchiEntity;
import com.software.no_appearance_back.domain.MensajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    ChatBl chatBl;

    @Autowired
    public ChatController(ChatBl chatBl) {
        this.chatBl = chatBl;
    }


    @RequestMapping(value = "/chat/guardar", method = RequestMethod.POST)
    public ResponseEntity registrarCliente(@RequestBody MatchiEntity matchEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
        chatBl.registrarChat(matchEntity);
        return new ResponseEntity("Creado", HttpStatus.CREATED);
    }


    @RequestMapping(value = "/listarchats/{idCliente}", method = RequestMethod.GET)
    public ResponseEntity listarChatsPorIdCliente(@PathVariable(value = "idCliente")int idCliente) {
        List<ChatEntity> chatEntityList= chatBl.listarChatsPorIdCliente(idCliente);
        return new ResponseEntity(chatEntityList, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/mensajeschat",method = RequestMethod.POST)
    public ResponseEntity mensajesChat(@RequestBody ChatEntity chatEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
        List<MensajeEntity>  mensajeEntityList=  chatBl.mensajesChat(chatEntity);
        return new ResponseEntity(mensajeEntityList, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/mensajeschatguardar",method = RequestMethod.POST)
    public ResponseEntity mensajeschatguardar(@RequestBody MensajeEntity mensajeEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
        chatBl.mensajeschatguardar(mensajeEntity);
        return new ResponseEntity("Guardado", HttpStatus.CREATED);
    }



}
