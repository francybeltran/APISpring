/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

import java.util.List;

public class Response<T> {

    private List<T> result = null;
    private String message;

    public Response() {
    }

    public Response(List<T> result, String message) {
        super();
        this.result = result;
        this.message = message;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}