package com.school.database.school.DTO;

import lombok.Data;

@Data
public class AuthResponse {

    private String token;
    private String tokenType = "Bearer ";
    private String fullToken;

    public AuthResponse(String token) {
        this.token = token;
        this.fullToken = tokenType + token;
    }

}
