package com.movix.movix.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final long EXPIRATION = 1000 * 60 * 60 * 24;
    private final SecretKey SECRET_KEY;

    public JwtUtil (@Value("${jwt.secret}") String secret) {
        if (secret.length() < 32) {
            throw new IllegalArgumentException("A chave JWT precisa ter no mínimo 32 caracteres.");
        }
        this.SECRET_KEY = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // método chamado quando o login é feito com sucesso 
    public String gerarToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)).signWith(SECRET_KEY, SignatureAlgorithm.HS256).compact();
    }

    public String getUsername(String token) throws JwtException {
        return Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload().getSubject();
    }
}
