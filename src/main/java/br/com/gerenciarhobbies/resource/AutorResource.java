package br.com.gerenciarhobbies.resource;

import br.com.gerenciarhobbies.domain.Autor;
import br.com.gerenciarhobbies.service.AutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static br.com.gerenciarhobbies.shared.Constantes.URI.URI_AUTOR;

@RestController
@RequestMapping(URI_AUTOR)
public class AutorResource {

    private final AutorService autorService;
    private final Logger LOGGER  = LoggerFactory.getLogger(AutorResource.class);

    public AutorResource(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listar() {
        LOGGER.debug("Requisição REST para consultar todos os autores");
        return ResponseEntity.status(HttpStatus.OK).body(this.autorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscar(@PathVariable("id") Long id) {
        LOGGER.debug("Requisição REST para consultar um autor em especifico: {} ", id);
        return ResponseEntity.ok(this.autorService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Autor> cadastrar(@Valid @RequestBody Autor autor) throws URISyntaxException {
        LOGGER.debug("Requisição REST para cadastrar um novo autor com parametros: {}", autor);
        Autor autorSalvo = this.autorService.salvar(autor);
        return ResponseEntity.created(new URI(URI_AUTOR + autorSalvo.getId())).body(autorSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> editar(@PathVariable("id") Long id, @Valid @RequestBody Autor autor) {
        LOGGER.debug("Requisição REST para atualizar um autor existente com parametros: {}", id, autor);
        autor.setId(id);
        return ResponseEntity.ok(this.autorService.atualizar(autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        LOGGER.debug("Requisição REST para apagar um autor existente com id: {}", id);
        this.autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
