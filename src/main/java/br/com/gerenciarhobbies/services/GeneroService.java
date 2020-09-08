package br.com.gerenciarhobbies.services;

import br.com.gerenciarhobbies.domain.Genero;

import java.util.List;

public interface GeneroService {

    void salvar(Genero genero);

    List<Genero> listar();

    Genero buscar(Long id);
}
