package com.example.JWT_upload_download.model;

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