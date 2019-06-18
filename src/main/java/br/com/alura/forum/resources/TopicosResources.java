package br.com.alura.forum.resources;

import br.com.alura.forum.domain.Curso;
import br.com.alura.forum.domain.Topico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosResources {

    @GetMapping
    public List<Topico> listarTodos(){
        return Arrays.asList(new Topico("Duvida", "Duvida com spring", new Curso("Spring", "Programacao"))) ;
    }

}
