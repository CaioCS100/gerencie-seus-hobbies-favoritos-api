package br.com.gerenciarhobbies.service;

import br.com.gerenciarhobbies.domain.Autor;

import java.util.List;

public interface AutorService  {

    Autor salvar(Autor autor);

    List<Autor> listar();

    Autor buscar(Long id);

    Autor atualizar(Autor autor);

    void deletar(Long id);
}
