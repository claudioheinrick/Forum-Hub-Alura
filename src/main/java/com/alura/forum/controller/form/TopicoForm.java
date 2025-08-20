package com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import com.alura.forum.modelo.Curso;
import com.alura.forum.modelo.Topico;
import com.alura.forum.modelo.Usuario;
import com.alura.forum.repository.TopicoRepository;

public class TopicoForm {
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String mensaje;
    
    @NotBlank
    private String nombreCurso;
    
    // Getters and Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    
    public String getNombreCurso() { return nombreCurso; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }
    
    public Topico convertir(Curso curso, Usuario autor) {
        return new Topico(titulo, mensaje, autor, curso);
    }
    
    public Topico actualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getOne(id);
        topico.setTitulo(this.titulo);
        topico.setMensaje(this.mensaje);
        return topico;
    }
}
