package br.com.gerenciarhobbies.repository;

import br.com.gerenciarhobbies.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmailIgnoreCaseOrLoginIgnoreCase(String email, String login);

    Integer countByEmailIgnoreCase(String email);

    Integer countByLoginIgnoreCase(String login);
}
