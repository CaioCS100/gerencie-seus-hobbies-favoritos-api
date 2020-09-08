package br.com.gerenciarhobbies.resources;

import br.com.gerenciarhobbies.domain.Genero;
import br.com.gerenciarhobbies.services.GeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<Void> salvar(@Valid @RequestBody Genero genero) {
        this.generoService.salvar(genero);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Genero>> listar() {
        return ResponseEntity.ok(this.generoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.generoService.buscar(id));
    }
}
