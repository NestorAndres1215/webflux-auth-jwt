package com.example.auth_webflux.controller;

import com.example.auth_webflux.model.Usuario;
import com.example.auth_webflux.security.JwtUtil;
import com.example.auth_webflux.service.UsuarioService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public Mono<Usuario> register(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PostMapping("/login")
    public Mono<Usuario> login(@RequestBody Usuario usuario) {
        return usuarioService.findByUsername(usuario.getUsername());
    }
}