package br.com.bgt.firstsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bgt.firstsystem.entities.Marca;
import br.com.bgt.firstsystem.repository.MarcaRepository;

@RestController
@CrossOrigin("*")
public class MarcaController {

	@Autowired
	private MarcaRepository marcaService;

	@RequestMapping(value = "/marca/all", method = RequestMethod.GET)
	public List<Marca> getAllMarcas() {
		System.out.println("Get ALl Marcas API");
		return marcaService.findAll();
	}

	@RequestMapping(value = "/marca/find/{id}", method = RequestMethod.GET)
	public Marca getMarcaById(@PathVariable("id") long id) {
		System.out.println("Get Marca By Id API");
		Marca marca = marcaService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Marca Não Encontrado para esse id: " + id));

		if (marca == null) {
			return null;
		}
		return marca;

	}

	@RequestMapping(value = "/marca/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteMarca(@PathVariable long id) {
		System.out.println("Delete Marca API");
		marcaService.deleteById(id);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@RequestMapping(value = "/marca/create", method = RequestMethod.POST)
	public Marca createMarca(@Valid @RequestBody Marca marca) {
		return marcaService.save(marca);
	}

	@RequestMapping(value = "/marca/update", method = RequestMethod.PUT)
	public Marca updateMarca(@Valid @RequestBody Marca marca) {
		return marcaService.save(marca);
	}

}
