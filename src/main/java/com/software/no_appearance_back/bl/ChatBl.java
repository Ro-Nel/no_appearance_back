package com.software.no_appearance_back.bl;

import com.software.no_appearance_back.dao.ChatRepository;
import com.software.no_appearance_back.dao.MatchRepository;
import com.software.no_appearance_back.dao.MensajeRepository;
import com.software.no_appearance_back.domain.*;
import com.software.no_appearance_back.model.Chat;
import com.software.no_appearance_back.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class ChatBl {
    ChatRepository chatRepository;
    MatchRepository matchRepository;
    MensajeRepository mensajeRepository;

    @Autowired
    public ChatBl(ChatRepository chatRepository, MatchRepository matchRepository, MensajeRepository mensajeRepository) {
        this.chatRepository = chatRepository;
        this.matchRepository = matchRepository;
        this.mensajeRepository = mensajeRepository;
    }

    public void registrarChat(Match matchEntity) {
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


    public List<Chat> listarChatsPorIdCliente(int idCliente) {
        List<ChatEntity> chatEntityList= chatRepository.findMatchEntityByEstadoAndIdCliente1OrIdCliente2(1, idCliente,idCliente);
        List<Chat> chatList = new ArrayList<>();
        String nombre = "";
        for (ChatEntity c: chatEntityList) {
            if(idCliente == c.getIdCliente1())
                nombre = chatRepository.findNameChatByIdCliente(c.getIdCliente2(),idCliente);
            else
                nombre = chatRepository.findNameChatByIdCliente(c.getIdCliente1(),idCliente);
            Chat chat = new Chat(c.getIdChat(),c.getIdCliente1(),c.getIdCliente2(),nombre);
            chatList.add(chat);
        }
        return chatList;
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

    public void agregarChatPorIdMatch(int idMacth) {
        MatchiEntity matchiEntity = matchRepository.findByIdMatch(idMacth);
        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setEstado(1);
        chatEntity.setIdCliente1(matchiEntity.getIdCliente1());
        chatEntity.setIdCliente2(matchiEntity.getIdCliente2());
        chatEntity= transaccionChatEntity(chatEntity);
        chatRepository.save(chatEntity);

    }

    private ChatEntity transaccionChatEntity(ChatEntity chatEntity) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        chatEntity.setTxId(0); // Id de la transaccion
        chatEntity.setTxHost("192.168.0.1"); // Direccion Ip
        chatEntity.setTxUser(0);
        chatEntity.setTxDate(new Timestamp(System.currentTimeMillis())); // Fecha Actual
        chatEntity.setTxUpdate(new Date(System.currentTimeMillis()));
        return chatEntity;
    }

}

