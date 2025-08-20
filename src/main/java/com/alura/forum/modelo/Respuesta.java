package com.alura.forum.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "respuestas")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Lob
    private String mensaje;
    
    @ManyToOne
    private Topico topico;
    
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    
    @ManyToOne
    private Usuario autor;
    
    private Boolean solucion = false;
    
    // Constructors
    public Respuesta() {}
    
    public Respuesta(String mensaje, Topico topico, Usuario autor) {
        this.mensaje = mensaje;
        this.topico = topico;
        this.autor = autor;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    
    public Topico getTopico() { return topico; }
    public void setTopico(Topico topico) { this.topico = topico; }
    
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    
    public Usuario getAutor() { return autor; }
    public void setAutor(Usuario autor) { this.autor = autor; }
    
    public Boolean getSolucion() { return solucion; }
    public void setSolucion(Boolean solucion) { this.solucion = solucion; }
}
