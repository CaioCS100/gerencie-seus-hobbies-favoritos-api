package br.com.gerenciarhobbies.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manga")
public class mangaResource {
    @RequestMapping(value = "/teste")
    public String teste() {
        return "Olá";
    }
}
