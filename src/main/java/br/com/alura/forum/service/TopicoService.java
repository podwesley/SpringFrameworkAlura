package br.com.alura.forum.service;

import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.dto.AtualizacaoTopicoFormDTO;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    public List<Topico> listarTodos() {

        return topicoRepository.findAll();
    }

    public List<Topico> buscarPorTopicosDoCurso(String nomeCurso) {
        return topicoRepository.findByCursoNome(nomeCurso);
    }


    public List<Topico> buscarTopicosDoUsuario(String nomeUsuario) {
        return topicoRepository.findByAutorNome(nomeUsuario);
    }

    public void salvar(Topico topico) {
        topicoRepository.save(topico);

    }

    public Topico buscarTopicoPorId(Long id) {

        return topicoRepository.findById(id).orElse(new Topico());

    }

    public void deletarUmTopico(Long id) {

        topicoRepository.deleteById(id);

    }

    public Topico atualizar(Long id, AtualizacaoTopicoFormDTO atualizacaotopicoForm) {

        Topico topico = buscarTopicoPorId(id);
        topico.setTitulo(atualizacaotopicoForm.getMensagem());

        return topicoRepository.save(atualizacaotopicoForm.converterAtualizacaoTopicoFormDTOtoTopico(topico));
    }
}
