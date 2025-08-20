package com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
    @NotBlank
    private String email;
    
    @NotBlank
    private String senha;
    
    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public UsernamePasswordAuthenticationToken convertir() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
