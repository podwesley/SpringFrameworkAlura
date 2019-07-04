package br.com.alura.forum.resources;

import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.dto.*;
import br.com.alura.forum.service.CursoService;
import br.com.alura.forum.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<DetalharTopicoDTO> listarDetalhesPorTopico(@PathVariable("id") Long id) {

        Optional<Topico> topicoOptional = topicoService.buscarTopicoPorId(id);

        if (topicoOptional.isPresent()) {

            return ResponseEntity.ok().body(new DetalharTopicoDTO(topicoOptional.get()));

        } else return ResponseEntity.notFound().build();

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deletarUmTopicoNaMoral(@PathVariable("id") Long id) {

        Optional<Topico> topicoOptional = topicoService.buscarTopicoPorId(id);

        if (topicoOptional.isPresent()) {
            topicoService.deletarUmTopico(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();


    }

    //TODO - Bug do mau para resolver neste endpoint.
    @PutMapping(value = "{id}")
    public ResponseEntity<TopicoDTO> alterarMensagemDeUmTopico(@PathVariable("id") Long id, @RequestBody @Valid AtualizacaoTopicoFormDTO atualizacaotopicoForm) {

        Optional<Topico> topico = topicoService.buscarTopicoPorId(id);

        if (topico.isPresent()) {
            Topico topicoAtualizado = topicoService.atualizar(id, atualizacaotopicoForm);
            return ResponseEntity.ok().body(new TopicoDTO(topicoAtualizado));
        } else return ResponseEntity.notFound().build();

    }
}



