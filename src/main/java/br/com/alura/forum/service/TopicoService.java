package br.com.alura.forum.service;

import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.dto.AtualizacaoTopicoFormDTO;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Topico> buscarTopicoPorId(Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        return topicoOptional;

    }

    public void deletarUmTopico(Long id) {

        topicoRepository.deleteById(id);

    }

    public Topico atualizar(Long id, AtualizacaoTopicoFormDTO atualizacaotopicoForm) {

        Optional<Topico> topico = buscarTopicoPorId(id);

        if (topico.isPresent()) {
            topico.get().setMensagem(atualizacaotopicoForm.getMensagem());
            topicoRepository.saveAndFlush(topico.get());
            return topico.get();
        } else {

            return new Topico();
        }
    }
}
