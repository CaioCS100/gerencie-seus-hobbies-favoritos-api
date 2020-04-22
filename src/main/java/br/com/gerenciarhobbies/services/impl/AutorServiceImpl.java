package br.com.gerenciarhobbies.services.impl;

import br.com.gerenciarhobbies.domain.Autor;
import br.com.gerenciarhobbies.exceptions.EmailException;
import br.com.gerenciarhobbies.repository.AutorRepository;
import br.com.gerenciarhobbies.services.AutorService;
import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> listarAutores() {
        return this.autorRepository.findAll();
    }

    @Override
    public Autor salvarAutor(Autor autor) {
        autor.setId(null);
        verificarEmailCadastro(autor.getEmail());
        return this.autorRepository.save(autor);
    }

    private void verificarEmailCadastro(String email) {
        if (this.autorRepository.countAllByEmail(email) > 0)
            throw new EmailException(EMAIL_EXISTENTE);
    }
}
