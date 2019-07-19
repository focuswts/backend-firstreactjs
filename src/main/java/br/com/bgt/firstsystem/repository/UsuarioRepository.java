package br.com.bgt.firstsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bgt.firstsystem.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
