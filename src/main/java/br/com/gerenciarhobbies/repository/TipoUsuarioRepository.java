package br.com.gerenciarhobbies.repository;

import br.com.gerenciarhobbies.domain.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
}
