package br.com.gerenciarhobbies.repository;

import br.com.gerenciarhobbies.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Integer countAllByEmail(String email);
}
