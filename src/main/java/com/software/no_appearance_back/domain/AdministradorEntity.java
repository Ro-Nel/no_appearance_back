package com.software.no_appearance_back.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "administrador", schema = "no_appearance", catalog = "")
public class AdministradorEntity {
    private int idAdministrador;
    private String nombre;
    private String apellido;
    private Date nacimiento;
    private String correo;
    private String contrasena;
    private int txId;
    private String txHost;
    private int txUser;
    private Timestamp txDate;
    private Date txUpdate;

    @Id
    @Column(name = "id_administrador")
    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "nacimiento")
    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Basic
    @Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "contrasena")
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
        AdministradorEntity that = (AdministradorEntity) o;
        return idAdministrador == that.idAdministrador && txId == that.txId && txUser == that.txUser && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(nacimiento, that.nacimiento) && Objects.equals(correo, that.correo) && Objects.equals(contrasena, that.contrasena) && Objects.equals(txHost, that.txHost) && Objects.equals(txDate, that.txDate) && Objects.equals(txUpdate, that.txUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdministrador, nombre, apellido, nacimiento, correo, contrasena, txId, txHost, txUser, txDate, txUpdate);
    }
}
