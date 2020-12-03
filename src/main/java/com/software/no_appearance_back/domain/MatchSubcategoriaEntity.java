package com.software.no_appearance_back.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "match_subcategoria", schema = "no_appearance", catalog = "")
public class MatchSubcategoriaEntity {
    private int matchSubcategoria;
    private int idMatch;
    private int idSubcategoria;
    private int txId;
    private String txHost;
    private int txUser;
    private Timestamp txDate;
    private Date txUpdate;

    @Id
    @Column(name = "match_subcategoria")
    public int getMatchSubcategoria() {
        return matchSubcategoria;
    }

    public void setMatchSubcategoria(int matchSubcategoria) {
        this.matchSubcategoria = matchSubcategoria;
    }

    @Basic
    @Column(name = "id_match")
    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
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
        MatchSubcategoriaEntity that = (MatchSubcategoriaEntity) o;
        return matchSubcategoria == that.matchSubcategoria && idMatch == that.idMatch && idSubcategoria == that.idSubcategoria && txId == that.txId && txUser == that.txUser && Objects.equals(txHost, that.txHost) && Objects.equals(txDate, that.txDate) && Objects.equals(txUpdate, that.txUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchSubcategoria, idMatch, idSubcategoria, txId, txHost, txUser, txDate, txUpdate);
    }
}
