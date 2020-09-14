package br.com.gerenciarhobbies.services.impl;

import br.com.gerenciarhobbies.domain.Genero;
import br.com.gerenciarhobbies.repository.GeneroRepository;
import br.com.gerenciarhobbies.services.GeneroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public Genero cadastrar(Genero genero) {
        return this.generoRepository.salvar(genero);
    }

    @Override
    public Genero atualizar(Genero genero) {
        return this.generoRepository.atualizar(genero);
    }

    @Override
    public List<Genero> listar() {
        return this.generoRepository.listar();
    }

    @Override
    public Genero buscar(Long id) {
        if (id == null)
            System.out.println("lançar uma Excecao");

        return this.generoRepository.buscar(id);
    }

    @Override
    public void deletar(Long id) {
        if (id == null)
            System.out.println("lançar uma Excecao");

        this.generoRepository.deletar(id);
    }
}
