
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.ReservaRepositorio;
import com.helloworld.apispring.model.dao.ViajeRepositorio;
import com.helloworld.apispring.model.entity.Reserva;
import com.helloworld.apispring.model.entity.Viaje;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServicio {
    
    @Autowired
    private ReservaRepositorio reservarepositorio;

    public ReservaServicio() {
    }
    
    public List<Reserva> getAll() {
        return reservarepositorio.getAll();
    };
    
    public long createReserva(Reserva reserva){
        return reservarepositorio.createReserva(reserva);
    };
    
    public String updateReserva(Reserva reserva){
        if(reservarepositorio.updateReserva(reserva)){
            return "Se Actualizo";
        }else{
            return "No se pudo actualizar";
        }
    };
    
    public String deleteReserva(Reserva reserva){
        reservarepositorio.deleteReserva(reserva);
        return "funciona";
    };
    
}
