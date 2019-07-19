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

import br.com.bgt.firstsystem.entities.TabelaPreco;
import br.com.bgt.firstsystem.repository.TabelaPrecoRepository;

@RestController
@CrossOrigin("*")
public class TabelaPrecoController {

	@Autowired
	private TabelaPrecoRepository tabelaPrecoService;

	@RequestMapping(value = "/tabelap/all", method = RequestMethod.GET)
	public List<TabelaPreco> getAllTabelas() {
		System.out.println("Get ALl Tabelas API");
		return tabelaPrecoService.findAll();
	}

	@RequestMapping(value = "/tabelap/find/{id}", method = RequestMethod.GET)
	public TabelaPreco getTabelaById(@PathVariable("id") long id) {
		System.out.println("Get Tabela By Id API");
		TabelaPreco tabelaPreco = tabelaPrecoService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tabela Não Encontrado para esse id: " + id));

		if (tabelaPreco == null) {
			return null;
		}
		return tabelaPreco;

	}

	@RequestMapping(value = "/tabelap/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTabela(@PathVariable long id) {
		System.out.println("Delete Tabela Preco API");
		tabelaPrecoService.deleteById(id);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@RequestMapping(value = "/tabelap/create", method = RequestMethod.POST)
	public TabelaPreco createTabela(@Valid @RequestBody TabelaPreco tabelaPreco) {
		return tabelaPrecoService.save(tabelaPreco);
	}

	@RequestMapping(value = "/tabelap/update", method = RequestMethod.PUT)
	public TabelaPreco updateTabela(@Valid @RequestBody TabelaPreco tabelaPreco) {
		return tabelaPrecoService.save(tabelaPreco);
	}

}
