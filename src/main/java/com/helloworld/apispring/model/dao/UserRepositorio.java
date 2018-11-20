/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.User;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    public UserRepositorio() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getAll() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(User.class);
        /*for (int indice = 0; indice < criteria.list().size(); indice++) {
            System.out.println(criteria.list().get(indice));
            System.out.println(criteria.list().get(indice).getUsername());
        }*/
        return criteria.list();
    }

    public long createUser(User user) {
        user.setPass(getMD5(user.getPass()));
        Serializable save = getSessionFactory().getCurrentSession().save(user);
        return user.getUserid();
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUser(User user) {
        try {
            getSessionFactory().getCurrentSession().update(user);
            user.setPass(getMD5(user.getPass()));
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public User getUserByUserName(String userName) {
        User user = new User();
        try {
            Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(User.class);
            criteria.add(Restrictions.eq("username", userName));
            List<User> result = criteria.list();
            if (result.isEmpty()) {
                return null;
            } else {
                user = result.get(0);
            }

        } catch (HibernateException e) {
        }
        return user;
    }

    public void deleteUser(User user) {
        getSessionFactory().getCurrentSession().delete(user);
    }

}
