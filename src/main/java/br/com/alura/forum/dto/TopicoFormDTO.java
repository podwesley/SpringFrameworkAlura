package br.com.alura.forum.dto;

import br.com.alura.forum.domain.Curso;
import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicoFormDTO {

    private String titulo;
    private String mensagem;
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
                ", nomeCurso='" + nomeCurso + '\''+
                '}';
    }
}

