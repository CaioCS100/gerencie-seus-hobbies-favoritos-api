package br.com.gerenciarhobbies.repository;

import br.com.gerenciarhobbies.domain.Genero;

import java.util.List;

public interface GeneroRepositoryJdbc {

    void salvar(Genero genero);

    Genero buscar(Long id);

    List<Genero> listar();
}
