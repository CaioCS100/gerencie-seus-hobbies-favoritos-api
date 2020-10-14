package br.com.gerenciarhobbies.repository;

import br.com.gerenciarhobbies.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Integer countByEmail(String email);

    Integer countByEmailAndIdNotIn(String email, Long id);
}
