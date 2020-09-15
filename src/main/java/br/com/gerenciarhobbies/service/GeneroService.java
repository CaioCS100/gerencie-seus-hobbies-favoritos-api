package br.com.gerenciarhobbies.service;

import br.com.gerenciarhobbies.domain.Genero;

import java.util.List;

public interface GeneroService {

    Genero cadastrar(Genero genero);

    Genero atualizar(Genero genero, Long id);

    List<Genero> listar();

    Genero buscar(Long id);

    void deletar(Long id);
}
