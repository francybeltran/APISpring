/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.dto.LoginRequest;
import com.helloworld.apispring.dto.LoginResponse;
import com.helloworld.apispring.model.dao.UserRepositorio;
import com.helloworld.apispring.model.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicio {

    @Autowired
    private UserRepositorio userrepositorio;

    public UserServicio() {
    }

    public List<User> getAll() {
        return userrepositorio.getAll();
    }

    ;
    
    public long createUser(User user) {
        return userrepositorio.createUser(user);
    }

    ;

    public String updateUser(User user) {
        if (userrepositorio.updateUser(user)) {
            return "Se Actualizo";
        } else {
            return "No se pudo actualizar";
        }
    }

    ;
    
   public LoginResponse login(LoginRequest request) {
        User user = new User();
        LoginResponse response = new LoginResponse();
        user = userrepositorio.getUserByUserName(request.getUserName());

        if (user == null) {
            response.setResultado("el usuario no existe");
        } else {
            if (user.getActivo().equals("Inactivo")) {
                response.setResultado("Usuario inactivo");
            } else {
                if (request.getPassword().equals(user.getPass())) {
                    response.setResultado("login exitoso"); 
                } else {
                    response.setResultado("contraseña incorrecta");
                }
            }
        }

        return response;
    }

    public String deleteUser(User user) {
        userrepositorio.deleteUser(user);
        return "funciona";
    }
;

}
