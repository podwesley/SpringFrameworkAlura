package br.com.alura.forum.dto;

import br.com.alura.forum.domain.Curso;
import br.com.alura.forum.domain.Topico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoTopicoFormDTO {

    private String mensagem;

    public AtualizacaoTopicoFormDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico converterAtualizacaoTopicoFormDTOtoTopico(Topico topico) {
        return new Topico(topico.getMensagem());
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

