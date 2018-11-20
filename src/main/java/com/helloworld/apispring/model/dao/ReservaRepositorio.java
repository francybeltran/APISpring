package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Reserva;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReservaRepositorio {
    
    @Autowired
    private SessionFactory sessionFactory;

    public ReservaRepositorio() {
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Reserva> getAll() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Reserva.class);
        return criteria.list();
    }

    public long createReserva(Reserva reserva) {
        Serializable save = getSessionFactory().getCurrentSession().save(reserva);
        return reserva.getIdreserva();
    }
    
    public boolean updateReserva(Reserva reserva) {
        try{
            getSessionFactory().getCurrentSession().update(reserva);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void deleteReserva(Reserva reserva) {
        getSessionFactory().getCurrentSession().delete(reserva);
    }
    
}
