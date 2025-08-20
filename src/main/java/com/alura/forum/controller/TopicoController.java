package com.alura.forum.controller;

import com.alura.forum.controller.dto.TopicoDto;
import com.alura.forum.controller.form.TopicoForm;
import com.alura.forum.modelo.Curso;
import com.alura.forum.modelo.Topico;
import com.alura.forum.modelo.Usuario;
import com.alura.forum.repository.CursoRepository;
import com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> listar() {
        return TopicoDto.converter(topicoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> detalle(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new TopicoDto(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> crear(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Optional<Curso> cursoOptional = cursoRepository.findByNome(form.getNombreCurso());
        if (!cursoOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        // Obter usuário logado do contexto de segurança
        Usuario usuarioLogado = (Usuario) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        Topico topico = form.convertir(cursoOptional.get(), usuarioLogado);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> actualizar(@PathVariable Long id, @RequestBody @Valid TopicoForm form) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            Topico topico = form.actualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
