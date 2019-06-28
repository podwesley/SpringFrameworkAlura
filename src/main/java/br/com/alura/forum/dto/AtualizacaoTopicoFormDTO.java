package br.com.alura.forum.dto;

import br.com.alura.forum.domain.Topico;

public class AtualizacaoTopicoFormDTO {

    private String mensagem;

    public AtualizacaoTopicoFormDTO() {
    }

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

