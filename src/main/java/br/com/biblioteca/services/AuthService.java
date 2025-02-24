package br.com.biblioteca.services;


import br.com.biblioteca.dtos.LoginDto;

public interface AuthService  {
    String login(LoginDto loginDto);
}
