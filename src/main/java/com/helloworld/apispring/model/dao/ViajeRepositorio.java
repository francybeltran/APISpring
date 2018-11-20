/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.User;
import com.helloworld.apispring.model.entity.Viaje;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ViajeRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    public ViajeRepositorio() {
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Viaje> getAll() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Viaje.class);
        System.out.println("Informacion " + criteria.list().toString());
        return criteria.list();
    }
    
    public List<Viaje> Buscar(Viaje viaje) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Viaje.class);
        System.out.println( "1 " + viaje.getDestino() + " 2 " + viaje.getOrigen() + " 3 " + viaje.getFecinicio());
        if( viaje.getDestino() != "" && viaje.getOrigen() != ""  && viaje.getFecinicio() != null ){
            criteria.add(Restrictions.eq("destino", viaje.getDestino()));
            criteria.add(Restrictions.eq("origen", viaje.getOrigen()));
            criteria.add(Restrictions.ge("fecinicio", viaje.getFecinicio()));
        }else if(viaje.getDestino() != "" && viaje.getOrigen() != ""){
            criteria.add(Restrictions.eq("destino", viaje.getDestino()));
            criteria.add(Restrictions.eq("origen", viaje.getOrigen()));
        }else if(viaje.getDestino() != ""){
            criteria.add(Restrictions.eq("destino", viaje.getDestino()));
        }else if(viaje.getOrigen() != ""){
            criteria.add(Restrictions.eq("origen", viaje.getOrigen()));
        }else if(viaje.getFecinicio() != null){
            System.out.println(viaje.getFecinicio());
            criteria.add(Restrictions.ge("fecinicio", viaje.getFecinicio()));
        }
        
        
        //criteria.add(Restrictions.eq("idviaje", viaje.getIdviaje()));
        return criteria.list();
    }

    public long createViaje(Viaje viaje) {
        Serializable save = getSessionFactory().getCurrentSession().save(viaje);
        return viaje.getIdviaje();
    }
    
    public boolean updateViaje(Viaje viaje) {
        try{
            getSessionFactory().getCurrentSession().update(viaje);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void deleteViaje(Viaje viaje) {
        getSessionFactory().getCurrentSession().delete(viaje);
    }

}
