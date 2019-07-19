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

import br.com.bgt.firstsystem.entities.Vaga;
import br.com.bgt.firstsystem.repository.VagaRepository;

@RestController
@CrossOrigin("*")
public class VagaController {

	@Autowired
	private VagaRepository vagaService;

	@RequestMapping(value = "/vaga/all", method = RequestMethod.GET)
	public List<Vaga> getAllVagas() {
		System.out.println("Get ALl Vagas API");
		return vagaService.findAll();
	}

	@RequestMapping(value = "/vaga/find/{id}", method = RequestMethod.GET)
	public Vaga getVagaById(@PathVariable("id") long id) {
		System.out.println("Get Vaga By Id API");
		Vaga vaga = vagaService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vaga Não Encontrado para esse id: " + id));

		if (vaga == null) {
			return null;
		}
		return vaga;

	}

	@RequestMapping(value = "/vaga/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteVaga(@PathVariable long id) {
		System.out.println("Delete Vaga API");
		vagaService.deleteById(id);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@RequestMapping(value = "/vaga/create", method = RequestMethod.POST)
	public Vaga createVaga(@Valid @RequestBody Vaga vaga) {
		return vagaService.save(vaga);
	}

	@RequestMapping(value = "/vaga/update", method = RequestMethod.PUT)
	public Vaga updateVaga(@Valid @RequestBody Vaga vaga) {
		return vagaService.save(vaga);
	}

}
