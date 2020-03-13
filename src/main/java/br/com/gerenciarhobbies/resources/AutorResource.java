package br.com.gerenciarhobbies.resources;

import br.com.gerenciarhobbies.domain.Autor;
import br.com.gerenciarhobbies.services.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorResource {

    private final AutorService autorService;

    public AutorResource(AutorService autorService) {
        this.autorService = autorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Autor>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(this.autorService.listarAutores());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> cadastrar() {
        return null;
    }
}
