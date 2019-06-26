package br.com.alura.forum.service;

import br.com.alura.forum.domain.Curso;
import br.com.alura.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public Optional<Curso> buscarPorId(Long id) {
        Optional<Curso> byId = cursoRepository.findById(id);
        return byId;
    }


    public Curso buscarPorNome(String nomeCurso) {
        return cursoRepository.findByNome(nomeCurso);
    }
}
