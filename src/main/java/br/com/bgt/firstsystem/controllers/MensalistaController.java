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
import br.com.bgt.firstsystem.entities.Mensalista;
import br.com.bgt.firstsystem.repository.MensalistaRepository;

@RestController
@CrossOrigin("*")
public class MensalistaController {

	@Autowired
	private MensalistaRepository mensalistaService;

	@RequestMapping(value = "/mensalista/all", method = RequestMethod.GET)
	public List<Mensalista> getAllMensalistas() {
		System.out.println("Get ALl Mensalistas API");
		return mensalistaService.findAll();
	}

	@RequestMapping(value = "/mensalista/find/{id}", method = RequestMethod.GET)
	public Mensalista getMensalistaById(@PathVariable long id) {
		System.out.println("Get Mensalista By Id API");
		Mensalista mensalista = mensalistaService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Mensalista Não Encontrado para esse id: " + id));

		if (mensalista == null) {
			return null;
		}
		return mensalista;

	}

	@RequestMapping(value = "/mensalista/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteMensalista(@PathVariable long id) {
		System.out.println("Delete Mensalista API");
		mensalistaService.deleteById(id);

		String response = "success";
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@RequestMapping(value = "/mensalista/create", method = RequestMethod.POST)
	public Mensalista createMensalista(@Valid @RequestBody Mensalista mensalista) {
		return mensalistaService.save(mensalista);
	}

	@RequestMapping(value = "/mensalista/update", method = RequestMethod.PUT)
	public Mensalista updateMensalista(@Valid @RequestBody Mensalista mensalista) {
		return mensalistaService.save(mensalista);
	}

}
