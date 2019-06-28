package br.com.alura.forum.dto;

import br.com.alura.forum.domain.Curso;
import br.com.alura.forum.domain.Topico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicoFormDTO {

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 20)
    private String titulo;
    @NotNull
    @NotEmpty

    private String mensagem;
    @NotNull
    @NotEmpty

    private String nomeCurso;

    public TopicoFormDTO(String titulo, String mensagem, String nomeCurso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeCurso = nomeCurso;
    }

    public TopicoFormDTO() {
    }

    public Topico converterTopicoFormDTOtoTopico(String titulo, String mensagem, Curso curso) {
        return new Topico(titulo, mensagem, curso);
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "TopicoFormDTO{" +
                "titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", nomeCurso='" + nomeCurso + '\'' +
                '}';
    }
}

