package br.com.gerenciarhobbies.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorResource {

    @RequestMapping("/teste")
    public String teste() {
        return "teste aaasas";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> cadastrar() {
        return null;
    }
}
