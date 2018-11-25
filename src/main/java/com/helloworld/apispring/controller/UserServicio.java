/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.dto.LoginRequest;
import com.helloworld.apispring.dto.LoginResponse;
import com.helloworld.apispring.model.entity.User;
import com.helloworld.apispring.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicio {

    @Autowired
    private UserRepository userRepository;

    public UserServicio() {
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public long createUser(User user) {
        return userRepository.save(user).getUserid();
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        User user = userRepository.findFirstByUsername(request.getUserName());

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

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
