package br.com.gerenciarhobbies.service;

import br.com.gerenciarhobbies.domain.Autor;

import java.util.List;

public interface AutorService  {

    List<Autor> listarAutores();

    Autor salvarAutor(Autor autor);
}
