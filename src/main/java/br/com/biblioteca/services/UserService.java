package br.com.biblioteca.services;


import br.com.biblioteca.dtos.RegisterUserDto;

public interface UserService {
    void registerUser(RegisterUserDto registerUserDto);
}
