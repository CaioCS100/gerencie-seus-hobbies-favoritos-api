package br.com.gerenciarhobbies.services;

import br.com.gerenciarhobbies.domain.Autor;

import java.util.List;

public interface AutorService  {

    List<Autor> listarAutores();

    Autor salvarAutor(Autor autor);
}
