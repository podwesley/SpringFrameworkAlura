package br.com.alura.forum.dto;

import br.com.alura.forum.domain.Topico;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioTopicosDTO implements Serializable {


    private Long id;
    private String nome;
    private String email;
    private String curso;


    public UsuarioTopicosDTO(Topico topico) {
        this.id = topico.getAutor().getId();
        this.nome = topico.getAutor().getNome();
        this.email = topico.getAutor().getEmail();
        this.curso = topico.getCurso().getNome();
    }

    public static List<UsuarioTopicosDTO> converterTopicoToUsuarioTopicoDTO(List<Topico> Topicos) {
        return Topicos.stream().map(UsuarioTopicosDTO::new).collect(Collectors.toList());

    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
