package com.example.auth_webflux.security;


import com.example.auth_webflux.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter implements WebFilter {


    private  final JwtUtil jwtUtil;


    private final UsuarioService usuarioService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String username = jwtUtil.extractUsername(token);

            return usuarioService.findByUsername(username)
                    .filter(user -> jwtUtil.isTokenValid(token, user.getUsername()))
                    .flatMap(user -> chain.filter(exchange)
                            .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(
                                    Mono.just(new SecurityContextImpl(
                                            new UsernamePasswordAuthenticationToken(user.getUsername(), null, null))
                                    )
                            ))
                    )
                    .switchIfEmpty(chain.filter(exchange));
        }

        return chain.filter(exchange);
    }
}