package com.software.no_appearance_back.model;

public class MatchSubcategoria {
    private int matchSubcategoria;
    private int idMatch;
    private int idSubcategoria;
    private String subcategoria;
    private String foto;

    public MatchSubcategoria(int matchSubcategoria, int idMatch, int idSubcategoria, String subcategoria,String foto) {
        this.matchSubcategoria = matchSubcategoria;
        this.idMatch = idMatch;
        this.idSubcategoria = idSubcategoria;
        this.subcategoria = subcategoria;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public int getMatchSubcategoria() {
        return matchSubcategoria;
    }

    public void setMatchSubcategoria(int matchSubcategoria) {
        this.matchSubcategoria = matchSubcategoria;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }
}
