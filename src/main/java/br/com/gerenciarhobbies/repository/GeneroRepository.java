package br.com.gerenciarhobbies.repository;

import br.com.gerenciarhobbies.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long>, GeneroRepositoryJdbc {
}
