package br.com.alura.forum.dto;

import br.com.alura.forum.domain.Resposta;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RespostaDTO {

    private String mensagem;
    boolean solucionado;

    public RespostaDTO(Resposta resposta) {
        this.mensagem = resposta.getMensagem();
        this.solucionado = resposta.getSolucao();
    }

    public RespostaDTO() {}

    public static List<RespostaDTO> converterToRespostaDTO(List<Resposta> respostas) {
        return respostas.stream().map(RespostaDTO::convertRespostaToDTO).collect(Collectors.toList());
    }

    public static RespostaDTO convertRespostaToDTO(Resposta resposta){
        RespostaDTO dto = new RespostaDTO();
        dto.setMensagem(resposta.getMensagem());
        dto.setSolucionado(resposta.getSolucao());
        return dto;
    }


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isSolucionado() {
        return solucionado;
    }

    public void setSolucionado(boolean solucionado) {
        this.solucionado = solucionado;
    }
}
