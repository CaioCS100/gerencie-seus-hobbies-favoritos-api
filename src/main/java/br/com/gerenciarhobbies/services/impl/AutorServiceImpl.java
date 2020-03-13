package br.com.gerenciarhobbies.services.impl;

import br.com.gerenciarhobbies.domain.Autor;
import br.com.gerenciarhobbies.repository.AutorRepository;
import br.com.gerenciarhobbies.services.AutorService;
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
        verificarEmail(autor.getEmail());
        return null;
    }

    private void verificarEmail(String email) {

    }
}
