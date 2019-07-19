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

import br.com.bgt.firstsystem.entities.Estado;
import br.com.bgt.firstsystem.entities.User;
import br.com.bgt.firstsystem.repository.EstadoRepository;

@RestController
@CrossOrigin("*")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoService;

	@RequestMapping(value = "/estado/all", method = RequestMethod.GET)
	public List<Estado> getAllEstados() {
		System.out.println("Get ALl Estados API");
		return estadoService.findAll();
	}

	@RequestMapping(value = "/estado/find/{id}", method = RequestMethod.GET)
	public Estado getEstadoById(@PathVariable("id") long id) {
		System.out.println("Get Estado By Id API");
		Estado estado = estadoService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Estado Não Encontrado para esse id: " + id));

		if (estado == null) {
			return null;
		}
		return estado;

	}

	@RequestMapping(value = "/estado/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEstado(@PathVariable long id) {
		System.out.println("Delete Estado API");
		estadoService.deleteById(id);

		String response = "success";
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@RequestMapping(value = "/estado/create", method = RequestMethod.POST)
	public Estado createEstado(@Valid @RequestBody Estado estado) {
		return estadoService.save(estado);
	}

	@RequestMapping(value = "/estado/update", method = RequestMethod.PUT)
	public Estado updateEstado(@Valid @RequestBody Estado estado) {
		return estadoService.save(estado);
	}

}
