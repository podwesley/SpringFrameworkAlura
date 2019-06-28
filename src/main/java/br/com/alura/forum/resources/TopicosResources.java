package br.com.alura.forum.resources;

import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.dto.*;
import br.com.alura.forum.service.CursoService;
import br.com.alura.forum.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping(value = "/pesquisar/{nomeUsuario}")
    public List<UsuarioTopicosDTO> buscarTopicosDoUsuario(@PathVariable("nomeUsuario") String nomeUsuario) {

        return UsuarioTopicosDTO.converterTopicoToUsuarioTopicoDTO(topicoService.buscarTopicosDoUsuario(nomeUsuario));
    }

    @PostMapping
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoFormDTO topicoForm, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoForm.converterTopicoFormDTOtoTopico(topicoForm.getTitulo(), topicoForm.getMensagem(), cursoService.buscarPorNome(topicoForm.getNomeCurso()));
        topicoService.salvar(topico);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @GetMapping(value = "{id}")
    public DetalharTopicoDTO listarDetalhesPorTopico(@PathVariable("id") Long id) {
        Topico topico = topicoService.buscarTopicoPorId(id);
        return new DetalharTopicoDTO(topico);
    }

    @DeleteMapping(value = "{id}")
    public void deletarUmTopicoNaMoral(@PathVariable("id") Long id){
        topicoService.deletarUmTopico(id);
    }

    @PutMapping(value = "{id}")
    public void alterarMensagemDeUmTopico(@RequestBody String mensagem, @PathVariable("id") Long id){
        Topico topico = topicoService.buscarTopicoPorId(id);
        topicoService.salvar(topico);
    }

}



