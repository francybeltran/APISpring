/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.repositories;

import com.helloworld.apispring.model.entity.User;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author Entelgy
 */
public interface UserRepository extends CrudRepository<User, Long> {
    
    User findFirstByUsername(String username);
    
}
