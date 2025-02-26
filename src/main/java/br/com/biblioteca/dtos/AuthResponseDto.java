package br.com.biblioteca.dtos;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
