/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "USUARIO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EquipoGenerator")
    @SequenceGenerator(name = "EquipoGenerator", sequenceName = "usuario_id_usuario_seq", allocationSize = 1)

    @Column(name = "ID_USUARIO")
    private Long userid;
    
    @Column(name = "USER_NAME")
    private String username;
    
    @Column(name = "PASS")
    private String pass;
    
    @Column(name = "ACTIVO")
    private String activo;
    
    @Column(name = "ACT_HORA")
    private Date acthora;
    
    @Column(name = "ID_TIPO")
    private int idtipo;
   
    public User() {
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getActhora() {
        return acthora;
    }

    public void setActhora(Date acthora) {
        this.acthora = acthora;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }
    
}
