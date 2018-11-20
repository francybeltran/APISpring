/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VIAJE")
public class Viaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EquipoGenerator")
    @SequenceGenerator(name = "EquipoGenerator", sequenceName = "viaje_id_viaje_seq", allocationSize = 1)
    
    @Column(name = "ID_VIAJE")
    private long idviaje;
    
    @Column(name = "ID_ESTADO")
    private int idestado;
    
    @Column(name = "ORIGEN")
    private String origen;
    
    @Column(name = "DESTINO")
    private String destino;
    
    @Column(name = "FEC_INICIO")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fecinicio;
    
    @Column(name = "FEC_FIN")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fecfin;
    
    @Column(name = "ID_USUARIO")
    private int idusuario;
 
    @Column(name = "CUPOS")
    private double cupos;
    
    @Column(name = "VALOR_CUPO")
    private double valorcupo;
    
    @Column(name = "ACT_HORA")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date acthora;
    
    @Column(name = "ID_TIPO")
    private int idtpo;

    public Viaje() {
    }
    
    public long getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(long idviaje) {
        this.idviaje = idviaje;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date  getFecinicio() {
        return fecinicio;
    }

    public void setFecinicio(Date  fecinicio) {
        this.fecinicio = fecinicio;
    }

    public Date getFecfin() {
        return fecfin;
    }

    public void setFecfin(Date fecfin) {
        this.fecfin = fecfin;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public double getValorcupo() {
        return valorcupo;
    }

    public void setValorcupo(double valorcupo) {
        this.valorcupo = valorcupo;
    }

    public Date getActhora() {
        return acthora;
    }

    public void setActhora(Date acthora) {
        this.acthora = acthora;
    }

    public int getIdtpo() {
        return idtpo;
    }

    public void setIdtpo(int idtpo) {
        this.idtpo = idtpo;
    }

    public double getCupos() {
        return cupos;
    }

    public void setCupos(double cupos) {
        this.cupos = cupos;
    }
    
}
