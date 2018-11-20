/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.ViajeRepositorio;
import com.helloworld.apispring.model.entity.Viaje;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViajeServicio {
    
    @Autowired
    private ViajeRepositorio viajerepositorio;

    public ViajeServicio() {
    }
    
    public List<Viaje> getAll() {
        return viajerepositorio.getAll();
    };
    
    public List<Viaje> Buscar(Viaje viaje) {
        return viajerepositorio.Buscar(viaje);
    };
    
    public long createViaje(Viaje viaje){
        return viajerepositorio.createViaje(viaje);
    };
    
    public String updateViaje(Viaje viaje){
        if(viajerepositorio.updateViaje(viaje)){
            return "Se Actualizo";
        }else{
            return "No se pudo actualizar";
        }
    };
    
    public String deleteViaje(Viaje viaje){
        viajerepositorio.deleteViaje(viaje);
        return "funciona";
    };
    
}
