package br.com.gerenciarhobbies.resources;

import br.com.gerenciarhobbies.domain.Genero;
import br.com.gerenciarhobbies.services.GeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static br.com.gerenciarhobbies.shared.Constantes.URI.URI_GENERO;

@RestController
@RequestMapping(URI_GENERO)
public class GeneroResource {

    private final GeneroService generoService;

    public GeneroResource(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    public ResponseEntity<Genero> salvar(@Valid @RequestBody Genero genero) throws URISyntaxException {
        Genero generoSalvo = this.generoService.cadastrar(genero);
        return ResponseEntity.created(new URI(URI_GENERO + "/" + generoSalvo.getId())).body(generoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Genero>> listar() {
        return ResponseEntity.ok(this.generoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.generoService.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> atualizar(@PathVariable("id") Long id, @Valid @RequestBody Genero genero) {
        genero.setId(id);
        return ResponseEntity.ok(this.generoService.atualizar(genero));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        this.generoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
