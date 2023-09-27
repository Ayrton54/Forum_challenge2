package br.com.Forum_challenge2.controller;


import br.com.Forum_challenge2.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {
    @Autowired
    private TopicoRepostory repostory;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopicos dados,
                                    UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dados);
        repostory.save(topico);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosretornoTopico(topico));

    }

    @GetMapping
    public ResponseEntity<Page<ListagemTopico>> Listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        var page = repostory.findAllByAtivoTrue(paginacao).map(ListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTopico dados){
        var topico = repostory.getReferenceById(dados.id());
        topico.Atualizacao(dados);
        return ResponseEntity.ok(new DadosretornoTopico(topico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity Excluir(@PathVariable Long id){
        var topico = repostory.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.ok(new DadosretornoTopico(topico));
    }

    @GetMapping("/{id}")
    public  ResponseEntity detalhar(@PathVariable Long id){
        var topico = repostory.getReferenceById(id);
        return ResponseEntity.ok(new DadosretornoTopico(topico));
    }

}