package br.com.bgt.firstsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bgt.firstsystem.entities.Mensalista;

public interface MensalistaRepository extends JpaRepository<Mensalista, Long>{

}
