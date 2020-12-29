package br.com.gerenciarhobbies.resource;

import br.com.gerenciarhobbies.domain.Usuario;
import br.com.gerenciarhobbies.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.net.URI;
import java.net.URISyntaxException;

import static br.com.gerenciarhobbies.shared.Constantes.URI.URI_USUARIO;

@RestController
@RequestMapping(URI_USUARIO)
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario) throws URISyntaxException {
        Usuario usuarioSalvo = this.usuarioService.salvar(usuario);
        return ResponseEntity.created(new URI(URI_USUARIO + "/" + usuarioSalvo.getId())).body(usuarioSalvo);
    }
}
