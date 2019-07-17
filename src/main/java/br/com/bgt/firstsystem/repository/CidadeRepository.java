package br.com.bgt.firstsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bgt.firstsystem.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
