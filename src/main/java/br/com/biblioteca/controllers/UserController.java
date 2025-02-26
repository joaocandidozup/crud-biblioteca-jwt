package br.com.biblioteca.controllers;

import br.com.biblioteca.dtos.RegisterUserDto;
import br.com.biblioteca.jwt.JwtTokenProvider;
import br.com.biblioteca.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public void registerUser(@RequestBody RegisterUserDto registerUserDto) {
        userService.registerUser(registerUserDto);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String token) {
        try {

            String refreshToken = token.replace("Bearer ", "");

            if (!jwtTokenProvider.validateToken(refreshToken)) {
                return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body("Token inválido");
            }

            String username = jwtTokenProvider.getUsername(refreshToken);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String newToken = jwtTokenProvider.generateToken(authentication);

            return ResponseEntity.ok(Collections.singletonMap("token", newToken));
        } catch (Exception e) {
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body("Erro ao processar o token");
        }
    }
}