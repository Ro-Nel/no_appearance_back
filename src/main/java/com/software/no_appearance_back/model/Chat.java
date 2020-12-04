package com.software.no_appearance_back.model;

public class Chat {
    private int idChat;
    private int idCliente1;
    private int idCliente2;
    private String nameCliente;


    public Chat(int idChat, int idCliente1, int idCliente2, String nameCliente) {
        this.idChat = idChat;
        this.idCliente1 = idCliente1;
        this.idCliente2 = idCliente2;
        this.nameCliente = nameCliente;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public int getIdCliente1() {
        return idCliente1;
    }

    public void setIdCliente1(int idCliente1) {
        this.idCliente1 = idCliente1;
    }

    public int getIdCliente2() {
        return idCliente2;
    }

    public void setIdCliente2(int idCliente2) {
        this.idCliente2 = idCliente2;
    }

    public String getNameCliente() {
        return nameCliente;
    }

    public void setNameCliente(String nameCliente) {
        this.nameCliente = nameCliente;
    }

}
