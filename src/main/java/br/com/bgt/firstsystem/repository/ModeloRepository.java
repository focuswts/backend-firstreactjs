package br.com.bgt.firstsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bgt.firstsystem.entities.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

	@Query(value = "SELECT m FROM Modelo m WHERE m.idMarca.id = :id")
	List<Modelo> findAllByMarcaId(@Param("id") Long id);

	@Query(value = "SELECT m FROM Modelo m INNER JOIN Marca ma ON m.idMarca.id = ma.id"
			+ " WHERE m.idMarca.marca = :marca")
	List<Modelo> findAllByMarcaDesc(@Param("marca") String marca);

}
