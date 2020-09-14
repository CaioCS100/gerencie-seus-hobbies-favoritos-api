package br.com.gerenciarhobbies.repository;

import br.com.gerenciarhobbies.domain.Genero;

import java.util.List;

public interface GeneroRepositoryJdbc {

    Genero salvar(Genero genero);

    Genero atualizar(Genero genero);

    Genero buscar(Long id);

    List<Genero> listar();

    void deletar(Long id);
}
