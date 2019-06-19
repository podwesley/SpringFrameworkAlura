package br.com.alura.forum.resources;

import br.com.alura.forum.domain.Curso;
import br.com.alura.forum.domain.Topico;
import br.com.alura.forum.dto.TopicoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosResources {

    @GetMapping
    public List<TopicoDTO> listarTodos() {

        return TopicoDTO.converterToTopicoDTO(Arrays.asList(new Topico("Dúvidas Spring Framework", "Como devo criar DTOS com o springframework?", new Curso("Spring", "Programação"))));
    }
}
