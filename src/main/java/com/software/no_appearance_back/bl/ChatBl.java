package com.software.no_appearance_back.bl;

import com.software.no_appearance_back.dao.ChatRepository;
import com.software.no_appearance_back.dao.MatchRepository;
import com.software.no_appearance_back.dao.MensajeRepository;
import com.software.no_appearance_back.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class ChatBl {
    ChatRepository chatRepository;
    MensajeRepository mensajeRepository;

    @Autowired
    public ChatBl(ChatRepository chatRepository, MensajeRepository mensajeRepository) {
        this.chatRepository = chatRepository;
        this.mensajeRepository = mensajeRepository;
    }

    public void registrarChat(MatchEntity matchEntity) {
        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setIdCliente1(matchEntity.getIdCliente1());
        chatEntity.setIdCliente2(matchEntity.getIdCliente2());
        chatEntity.setEstado(1);
        chatEntity = transaccion(chatEntity);
        chatRepository.save(chatEntity);
    }

    private ChatEntity transaccion(ChatEntity chatEntity) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        chatEntity.setTxId(0); // Id de la transaccion
        chatEntity.setTxHost("192.168.0.1"); // Direccion Ip
        chatEntity.setTxUser(0);
        chatEntity.setTxDate(new Timestamp(System.currentTimeMillis())); // Fecha Actual
        chatEntity.setTxUpdate(new Date(System.currentTimeMillis()));
        return chatEntity;
    }


    public List<ChatEntity> listarChatsPorIdCliente(int idCliente) {
        List<ChatEntity> chatEntityList= chatRepository.findMatchEntityByEstadoAndIdCliente1OrIdCliente2(1, idCliente,idCliente);
        return chatEntityList;
    }

    public List<MensajeEntity> mensajesChat(ChatEntity chatEntity) {
        List<MensajeEntity> mensajeEntityList= mensajeRepository.findAllByIdChat(chatEntity.getIdChat());
        return mensajeEntityList;
    }

    public void mensajeschatguardar(MensajeEntity mensajeEntity) {
        mensajeEntity = transaccion(mensajeEntity);
        mensajeRepository.save(mensajeEntity);
    }

    private MensajeEntity transaccion(MensajeEntity mensajeEntity) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        mensajeEntity.setTxId(0); // Id de la transaccion
        mensajeEntity.setTxHost("192.168.0.1"); // Direccion Ip
        mensajeEntity.setTxUser(0);
        mensajeEntity.setTxDate(new Timestamp(System.currentTimeMillis())); // Fecha Actual
        mensajeEntity.setTxUpdate(new Date(System.currentTimeMillis()));
        return mensajeEntity;
    }

}

