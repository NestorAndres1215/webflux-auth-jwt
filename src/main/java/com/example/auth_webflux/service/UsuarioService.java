package com.example.auth_webflux.service;


import com.example.auth_webflux.model.Usuario;
import com.example.auth_webflux.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository repository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Mono<Usuario> saveUsuario(Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return repository.save(usuario);
    }

    public Mono<Usuario> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public boolean checkPassword(String raw, String encoded) {
        return encoder.matches(raw, encoded);
    }
}