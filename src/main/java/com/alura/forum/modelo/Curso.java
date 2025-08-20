package com.alura.forum.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(unique = true)
    private String nome;
    
    @NotBlank
    private String categoria;
    
    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos = new ArrayList<>();
    
    // Constructors
    public Curso() {}
    
    public Curso(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public List<Topico> getTopicos() { return topicos; }
    public void setTopicos(List<Topico> topicos) { this.topicos = topicos; }
}
