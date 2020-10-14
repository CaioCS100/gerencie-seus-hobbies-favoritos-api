package br.com.gerenciarhobbies.service.impl;

import br.com.gerenciarhobbies.domain.Autor;
import br.com.gerenciarhobbies.exception.CampoObrigatorioException;
import br.com.gerenciarhobbies.exception.RecursoExistenteException;
import br.com.gerenciarhobbies.exception.RecursoNaoEncontradoException;
import br.com.gerenciarhobbies.repository.AutorRepository;
import br.com.gerenciarhobbies.service.AutorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.*;
import static br.com.gerenciarhobbies.util.VerificadorUtil.estaVazioOuNulo;

@Service
@Transactional
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor salvar(Autor autor) {
        autor.setId(null);
        verificarEmailCadastro(autor.getEmail());
        return this.autorRepository.save(autor);
    }

    @Override
    public List<Autor> listar() {
        return this.autorRepository.findAll();
    }

    @Override
    public Autor buscar(Long id) {
        if (estaVazioOuNulo(id))
            throw new CampoObrigatorioException(ID_OBRIGATORIO);

        return this.autorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format(AUTOR_NAO_ENCONTRADO, id)));
    }

    @Override
    public Autor atualizar(Autor autor) {
        verificarSeAutorExiste(autor.getId());
        verificarEmailEdicao(autor);
        return this.autorRepository.save(autor);
    }

    @Override
    public void deletar(Long id) {
        verificarSeAutorExiste(id);
        this.autorRepository.deleteById(id);
    }


    private void verificarEmailCadastro(String email) {
        if (this.autorRepository.countByEmail(email) > 0)
            throw new RecursoExistenteException(EMAIL_EXISTENTE);
    }

    private void verificarEmailEdicao(Autor autor) {
        if (this.autorRepository.countByEmailAndIdNotIn(autor.getEmail(), autor.getId()) > 0)
            throw new RecursoExistenteException(EMAIL_EXISTENTE);
    }

    private void verificarSeAutorExiste(Long id) {
        buscar(id);
    }
}
