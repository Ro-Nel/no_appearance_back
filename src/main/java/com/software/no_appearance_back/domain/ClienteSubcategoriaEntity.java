package com.software.no_appearance_back.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cliente_subcategoria", schema = "no_appearance", catalog = "")
public class ClienteSubcategoriaEntity {
    private int idClienteSubcategoria;
    private int idCliente;
    private int idSubcategoria;
    private int txId;
    private String txHost;
    private int txUser;
    private Timestamp txDate;
    private Date txUpdate;

    @Id
    @Column(name = "id_cliente_subcategoria")
    public int getIdClienteSubcategoria() {
        return idClienteSubcategoria;
    }

    public void setIdClienteSubcategoria(int idClienteSubcategoria) {
        this.idClienteSubcategoria = idClienteSubcategoria;
    }

    @Basic
    @Column(name = "id_cliente")
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "id_subcategoria")
    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
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
        ClienteSubcategoriaEntity that = (ClienteSubcategoriaEntity) o;
        return idClienteSubcategoria == that.idClienteSubcategoria && idCliente == that.idCliente && idSubcategoria == that.idSubcategoria && txId == that.txId && txUser == that.txUser && Objects.equals(txHost, that.txHost) && Objects.equals(txDate, that.txDate) && Objects.equals(txUpdate, that.txUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClienteSubcategoria, idCliente, idSubcategoria, txId, txHost, txUser, txDate, txUpdate);
    }
}
