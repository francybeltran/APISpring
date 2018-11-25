/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.dto.LoginRequest;
import com.helloworld.apispring.dto.LoginResponse;
import com.helloworld.apispring.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    public UserServicio userservicio;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getUser() {
        return new ResponseEntity<>(userservicio.getAll(), HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> createUse(@RequestBody User user) {
//        long id = userservicio.createUser(user);
//        return ResponseEntity.ok().body("Nuevo usuario creado con ID:" + id);
//    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> UpdateUse(@RequestBody User user) {
//        String inf = userservicio.updateUser(user);
//        return ResponseEntity.ok().body(inf);
//    }
//
    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = userservicio.login(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> DeleteUse(@RequestBody User user) {
//        String inf = userservicio.deleteUser(user);
//        return ResponseEntity.ok().body(inf);
//    }
//
//    @Autowired
//    public ViajeServicio viajeservicio;
//
//    @RequestMapping(value = "/viajes", method = RequestMethod.GET)
//    public ResponseEntity<Response> getViajes() {
//        List<Viaje> viajes = viajeservicio.getAll();
//        Response response = new Response(viajes, "200");
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/buscarviajes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Response> getBuscarViajes(@RequestBody Viaje viaje) {
//        List<Viaje> viajes = viajeservicio.Buscar(viaje);
//        Response response = new Response(viajes, "200");
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/viajes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> createViaje(@RequestBody Viaje viaje) {
//        long id = viajeservicio.createViaje(viaje);
//        return ResponseEntity.ok().body("Nuevo Viaje creado con ID:" + id);
//    }
//
//    @RequestMapping(value = "/viajes", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> UpdateUse(@RequestBody Viaje viaje) {
//        String inf = viajeservicio.updateViaje(viaje);
//        return ResponseEntity.ok().body(inf);
//    }
//
//    @RequestMapping(value = "/viajes", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> DeleteUse(@RequestBody Viaje viaje) {
//        String inf = viajeservicio.deleteViaje(viaje);
//        return ResponseEntity.ok().body(inf);
//    }
//
//    @Autowired
//    public ReservaServicio reservaservicio;
//
//    @RequestMapping(value = "/reservas", method = RequestMethod.GET)
//    public ResponseEntity<List<Reserva>> getReserva() {
//        List<Reserva> reservas = reservaservicio.getAll();
//        return new ResponseEntity<>(reservas, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/reservas", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> createReserva(@RequestBody Reserva reserva) {
//        long id = reservaservicio.createReserva(reserva);
//        return ResponseEntity.ok().body("Nueva Reserva creado con ID:" + id);
//    }
//
//    @RequestMapping(value = "/reservas", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> UpdateReserva(@RequestBody Reserva reserva) {
//        String inf = reservaservicio.updateReserva(reserva);
//        return ResponseEntity.ok().body(inf);
//    }
//
//    @RequestMapping(value = "/reservas", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> DeleteUse(@RequestBody Reserva reserva) {
//        String inf = reservaservicio.deleteReserva(reserva);
//        return ResponseEntity.ok().body(inf);
//    }

}
