package br.com.bgt.firstsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bgt.firstsystem.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {


	@Query(value = "SELECT t FROM Telefone t WHERE t.idMensalista.id = :id")
	List<Telefone> findAllByMensalistaId(@Param("id") Long id);

	@Query(value = "SELECT t FROM Telefone t INNER JOIN Mensalista m ON t.idMensalista.id = m.id"
			+ " WHERE t.idMensalista.cpf = :cpf")
	List<Telefone> findAllByMensalistaCpf(@Param("cpf") String cpf);
}
