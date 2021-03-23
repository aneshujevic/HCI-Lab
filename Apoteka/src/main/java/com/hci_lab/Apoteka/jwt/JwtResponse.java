package com.hci_lab.Apoteka.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private String jwttoken;

    public JwtResponse() {
    }

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}