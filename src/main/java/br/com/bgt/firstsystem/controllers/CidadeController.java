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

import br.com.bgt.firstsystem.entities.Cidade;
import br.com.bgt.firstsystem.entities.Estado;
import br.com.bgt.firstsystem.repository.CidadeRepository;

@RestController
@CrossOrigin("*")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeService;

	@RequestMapping(value = "/cidade/all", method = RequestMethod.GET)
	public List<Cidade> getAllCidades() {
		System.out.println("Get ALl Cidade API");
		return cidadeService.findAll();
	}

	@RequestMapping(value = "/cidade/find/{id}", method = RequestMethod.GET)
	public Cidade getCidadeById(@PathVariable long id) {
		System.out.println("Get Estado By Id API");
		Cidade cidade = cidadeService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cidade Não Encontrado para esse id: " + id));

		if (cidade == null) {
			return null;
		}
		return cidade;
	}

	@RequestMapping(value = "/cidade/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCidade(@PathVariable long id) {
		System.out.println("Delete Cidade API");
		cidadeService.deleteById(id);
		String response = "success";
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/cidade/create", method = RequestMethod.POST)
	public Cidade createCidade(@Valid @RequestBody Cidade cidade) {
		return cidadeService.save(cidade);
	}

	@RequestMapping(value = "/cidade/update", method = RequestMethod.PUT)
	public Cidade updateCidade(@Valid @RequestBody Cidade cidade) {
		return cidadeService.save(cidade);
	}

}
