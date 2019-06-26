package br.com.alura.forum.resources;

import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.dto.TopicoFormDTO;
import br.com.alura.forum.dto.TopicosPorCursoDTO;
import br.com.alura.forum.dto.UsuarioTopicosDTO;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.service.CursoService;
import br.com.alura.forum.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosResources {

    @Autowired
    TopicoService topicoService;
    @Autowired
    CursoService cursoService;

    @GetMapping
    public List<TopicoDTO> listarTodos() {
        return TopicoDTO.converterToTopicoDTO(topicoService.listarTodos());
    }

    //Mostrar todos os dados da entidade no endpoint para testar os DTO's
    @GetMapping(value = "/entity")
    public List<Topico> test() {
        return topicoService.listarTodos();
    }

    //TODO situação a ser corrigida posteriormente com a classe Optional
    @GetMapping(value = "/pesquisar/{pesquisarTopicosPorCurso}")
    public List<TopicosPorCursoDTO> buscarPeloNomeDoCurso(@PathVariable("pesquisarTopicosPorCurso") String nomeCurso) {

        return TopicosPorCursoDTO.converterTopicoToTopicoPorCursoDTO(topicoService.buscarPorTopicosDoCurso(nomeCurso));
    }

    @GetMapping(value = "{nomeUsuario}")
    public List<UsuarioTopicosDTO> buscarTopicosDoUsuario(@PathVariable("nomeUsuario") String nomeUsuario) {

        return UsuarioTopicosDTO.converterTopicoToUsuarioTopicoDTO(topicoService.buscarTopicosDoUsuario(nomeUsuario));
    }

    @PostMapping
    public void cadastrar(@RequestBody TopicoFormDTO topicoForm) {

        TopicoFormDTO topicoForms = new TopicoFormDTO();
        Topico topico = topicoForms.converterTopicoFormDTOtoTopico(topicoForm.getTitulo(), topicoForm.getMensagem() , cursoService.buscarPorNome(topicoForm.getNomeCurso()));
        topicoService.salvar(topico);
    }
}



