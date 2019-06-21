package br.com.alura.forum.resources;

import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.dto.TopicosPorCursoDTO;
import br.com.alura.forum.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosResources {

    @Autowired
    TopicoService topicoService;

    @GetMapping
    public List<TopicoDTO> listarTodos() {
        return TopicoDTO.converterToTopicoDTO(topicoService.listarTodos());
    }

    //Mostrar todos os dados da entidade no endpoint para testar os DTO's
    @GetMapping(value = "/entity")
    public List<Topico> test() {
        return topicoService.listarTodos();
    }

    @GetMapping(value = "/pesquisar/{pesquisarTopicosPorCurso}")
    public List<TopicosPorCursoDTO> buscarPeloNomeDoCurso(@PathVariable("pesquisarTopicosPorCurso") String nomeCurso) {
        System.out.println(nomeCurso);
        Optional<Topico> topico = topicoService.buscarPorNomeDoCurso(nomeCurso);
        Topico topico1 = topico.get();
        System.out.println(topico.get());

        return TopicosPorCursoDTO.converterTopicoToTopicoPorCursoDTO(Arrays.asList(topico.get()));
    }
}
