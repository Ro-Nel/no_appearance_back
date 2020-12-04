package com.software.no_appearance_back.model;

public class Match {
    private int idMatch;
    private int idCliente1;
    private int idCliente2;
    private String nameCliente;


    public Match(int idMatch, int idCliente1, int idCliente2, String nameCliente) {
        this.idMatch = idMatch;
        this.idCliente1 = idCliente1;
        this.idCliente2 = idCliente2;
        this.nameCliente = nameCliente;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
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
