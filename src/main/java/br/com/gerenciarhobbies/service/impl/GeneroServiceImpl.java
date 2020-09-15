package br.com.gerenciarhobbies.service.impl;

import br.com.gerenciarhobbies.domain.Genero;
import br.com.gerenciarhobbies.exception.CampoObrigatorioException;
import br.com.gerenciarhobbies.exception.RecursoExistenteException;
import br.com.gerenciarhobbies.repository.GeneroRepository;
import br.com.gerenciarhobbies.service.GeneroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.*;
import static br.com.gerenciarhobbies.util.VerificadorUtil.estaNulo;

@Service
@Transactional
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public Genero cadastrar(Genero genero) {
        genero.setId(null);
        verificarSeDescricaoExiste(genero);
        return this.generoRepository.salvar(genero);
    }

    @Override
    public Genero atualizar(Genero genero, Long id) {
        genero.setId(id);
        verificarSeDescricaoExiste(genero);
        return this.generoRepository.atualizar(genero);
    }

    @Override
    public List<Genero> listar() {
        return this.generoRepository.listar();
    }

    @Override
    public Genero buscar(Long id) {
        if (estaNulo(id))
            throw new CampoObrigatorioException(ID_OBRIGATORIO);

        return this.generoRepository.buscar(id);
    }

    @Override
    public void deletar(Long id) {
        if (estaNulo(id))
            throw new CampoObrigatorioException(ID_OBRIGATORIO);

        this.generoRepository.deletar(id);
    }

    private void verificarSeDescricaoExiste(Genero genero) {
        if (this.generoRepository.verificarSeDescricaoExiste(genero))
            throw new RecursoExistenteException(GENERO_JA_CADASTRADO);
    }
}
