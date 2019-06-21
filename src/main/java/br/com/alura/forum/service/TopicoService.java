package br.com.alura.forum.service;

import br.com.alura.forum.domain.Topico;
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

    public Optional<Topico> buscarPorNomeDoCurso(String nomeCurso) {
        return Optional.ofNullable(topicoRepository.findByCursoNome(nomeCurso));
    }
}
