package com.software.no_appearance_back.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reporte", schema = "no_appearance", catalog = "")
public class ReporteEntity {
    private int idReporte;
    private int idReportero;
    private int idReportado;
    private String razon;
    private int txId;
    private String txHost;
    private int txUser;
    private Timestamp txDate;
    private Date txUpdate;

    @Id
    @Column(name = "id_reporte")
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    @Basic
    @Column(name = "id_reportero")
    public int getIdReportero() {
        return idReportero;
    }

    public void setIdReportero(int idReportero) {
        this.idReportero = idReportero;
    }

    @Basic
    @Column(name = "id_reportado")
    public int getIdReportado() {
        return idReportado;
    }

    public void setIdReportado(int idReportado) {
        this.idReportado = idReportado;
    }

    @Basic
    @Column(name = "razon")
    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
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
        ReporteEntity that = (ReporteEntity) o;
        return idReporte == that.idReporte && idReportero == that.idReportero && idReportado == that.idReportado && txId == that.txId && txUser == that.txUser && Objects.equals(razon, that.razon) && Objects.equals(txHost, that.txHost) && Objects.equals(txDate, that.txDate) && Objects.equals(txUpdate, that.txUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReporte, idReportero, idReportado, razon, txId, txHost, txUser, txDate, txUpdate);
    }
}
