package com.software.no_appearance_back.api;


import com.software.no_appearance_back.bl.ChatBl;
import com.software.no_appearance_back.domain.ChatEntity;
import com.software.no_appearance_back.domain.MatchiEntity;
import com.software.no_appearance_back.domain.MensajeEntity;
import com.software.no_appearance_back.model.Chat;
import com.software.no_appearance_back.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatController {

    ChatBl chatBl;

    @Autowired
    public ChatController(ChatBl chatBl) {
        this.chatBl = chatBl;
    }


    @RequestMapping(value = "/agregarChatPorIdMatch/{idMacth}", method = RequestMethod.GET)
    public ResponseEntity agregarChatPorIdMatch(@PathVariable(value = "idMacth")int idMacth) {
        chatBl.agregarChatPorIdMatch(idMacth);
        return new ResponseEntity("Creado", HttpStatus.CREATED);
    }


    @RequestMapping(value = "/chat/guardar", method = RequestMethod.POST)
    public ResponseEntity registrarCliente(@RequestBody Match match, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
        chatBl.registrarChat(match);
        return new ResponseEntity("Creado", HttpStatus.CREATED);
    }


    @RequestMapping(value = "/listarchats/{idCliente}", method = RequestMethod.GET)
    public ResponseEntity listarChatsPorIdCliente(@PathVariable(value = "idCliente")int idCliente) {
        List<Chat> chatList= chatBl.listarChatsPorIdCliente(idCliente);
        System.out.println(chatList.get(0).getNameCliente());
        return new ResponseEntity(chatList, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/mensajeschat/{idChatEntity}",method = RequestMethod.GET)
    public ResponseEntity mensajesChat(@PathVariable(value = "idChatEntity")int idChatEntity) {
        List<MensajeEntity>  mensajeEntityList=  new ArrayList<>();
        mensajeEntityList=  chatBl.mensajesChat(idChatEntity);
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
