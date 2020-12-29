package br.com.gerenciarhobbies.resource;

import br.com.gerenciarhobbies.service.UsuarioService;
import br.com.gerenciarhobbies.shared.dto.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static br.com.gerenciarhobbies.shared.Constantes.URI.URI_AUTENTICACAO;

@RestController
@RequestMapping(URI_AUTENTICACAO)
public class AutenticacaoResource {

    private final Logger LOGGER  = LoggerFactory.getLogger(AutorResource.class);
    private final UsuarioService usuarioService;


    public AutenticacaoResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> autenticarUsuario(@Valid @RequestBody LoginDTO loginDTO) {
        LOGGER.debug("Requisição REST para autenticar um usuário: {}", loginDTO);
        this.usuarioService.autenticar(loginDTO);
        return ResponseEntity.noContent().build();
    }
}
