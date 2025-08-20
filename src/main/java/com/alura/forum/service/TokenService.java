package com.alura.forum.service;

import com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;
    
    public String generarToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Date hoy = new Date();
        Date expiracion = new Date(hoy.getTime() + 86400000); // 24 horas
        
        return Jwts.builder()
                .setIssuer("Forum Hub API")
                .setSubject(usuario.getId().toString())
                .setIssuedAt(hoy)
                .setExpiration(expiracion)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    
    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
