package br.com.bgt.firstsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bgt.firstsystem.entities.Mensalista;

public interface MensalistaRepository extends JpaRepository<Mensalista, Long>{

	
	
	@Query(value="SELECT * FROM mensalista m WHERE m.cpf = :cpf",nativeQuery = true)
	public Mensalista findByCpf(@Param("cpf") String cpf);
	
	
}
