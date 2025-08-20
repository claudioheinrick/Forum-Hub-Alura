package com.alura.forum.controller.dto;

import com.alura.forum.modelo.StatusTopico;
import com.alura.forum.modelo.Topico;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private StatusTopico status;
    private String autor;
    private String curso;
    
    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensaje = topico.getMensaje();
        this.fechaCreacion = topico.getFechaCreacion();
        this.status = topico.getStatus();
        this.autor = topico.getAutor().getNome();
        this.curso = topico.getCurso().getNome();
    }
    
    public static List<TopicoDto> converter(List<Topico> topicos) {
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }
    
    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getMensaje() { return mensaje; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public StatusTopico getStatus() { return status; }
    public String getAutor() { return autor; }
    public String getCurso() { return curso; }
}
