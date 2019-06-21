package br.com.alura.forum.dto;

import br.com.alura.forum.domain.Curso;
import br.com.alura.forum.domain.Topico;

import java.util.List;
import java.util.stream.Collectors;

public class TopicosPorCursoDTO {

    private Long id;
    private String titulo;
    private Curso curso;

    public TopicosPorCursoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.curso.setNome(topico.getCurso().getNome());
    }

    public static List<TopicosPorCursoDTO> converterTopicoToTopicoPorCursoDTO(List<Topico> topico) {
        return topico.stream().map(TopicosPorCursoDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
