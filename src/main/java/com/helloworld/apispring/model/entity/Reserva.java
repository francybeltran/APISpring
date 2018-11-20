package com.helloworld.apispring.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReservaGenerator")
    @SequenceGenerator(name = "ReservaGenerator", sequenceName = "reserva_id_reserva_seq", allocationSize = 1)
    
    @Column(name = "ID_RESERVA")
    private long idreserva;
    
    @Column(name = "ID_USUARIO")
    private int idusuario;
    
    @Column(name = "ID_VIAJE")
    private int idviaje;
    
    @Column(name = "CUPOS")
    private int cupos;
    
    @Column(name = "VALOR")
    private double valor;

    @Column(name = "ACT_ESTA")
    private String actesta;
    
    @Column(name = "ACT_HORA")
    private Date acthora;

    public Reserva() {
    }

    public long getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(long idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(int idviaje) {
        this.idviaje = idviaje;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getActesta() {
        return actesta;
    }

    public void setActesta(String actesta) {
        this.actesta = actesta;
    }

    public Date getActhora() {
        return acthora;
    }

    public void setActhora(Date acthora) {
        this.acthora = acthora;
    }

    
    
}
