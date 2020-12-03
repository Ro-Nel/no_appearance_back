package com.software.no_appearance_back.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "categoria", schema = "no_appearance", catalog = "")
public class CategoriaEntity {
    private int idCategoria;
    private String categoria;
    private String foto;
    private int txId;
    private String txHost;
    private int txUser;
    private Timestamp txDate;
    private Date txUpdate;

    @Id
    @Column(name = "id_categoria")
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Basic
    @Column(name = "categoria")
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "foto")
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Basic
    @Column(name = "tx_id")
    public int getTxId() {
        return txId;
    }

    public void setTxId(int txId) {
        this.txId = txId;
    }

    @Basic
    @Column(name = "tx_host")
    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    @Basic
    @Column(name = "tx_user")
    public int getTxUser() {
        return txUser;
    }

    public void setTxUser(int txUser) {
        this.txUser = txUser;
    }

    @Basic
    @Column(name = "tx_date")
    public Timestamp getTxDate() {
        return txDate;
    }

    public void setTxDate(Timestamp txDate) {
        this.txDate = txDate;
    }

    @Basic
    @Column(name = "tx_update")
    public Date getTxUpdate() {
        return txUpdate;
    }

    public void setTxUpdate(Date txUpdate) {
        this.txUpdate = txUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return idCategoria == that.idCategoria && txId == that.txId && txUser == that.txUser && Objects.equals(categoria, that.categoria) && Objects.equals(foto, that.foto) && Objects.equals(txHost, that.txHost) && Objects.equals(txDate, that.txDate) && Objects.equals(txUpdate, that.txUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, categoria, foto, txId, txHost, txUser, txDate, txUpdate);
    }
}
