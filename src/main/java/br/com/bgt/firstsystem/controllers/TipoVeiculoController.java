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

import br.com.bgt.firstsystem.entities.TipoVeiculo;
import br.com.bgt.firstsystem.repository.TipoVeiculoRepository;

@RestController
@CrossOrigin("*")
public class TipoVeiculoController {

	@Autowired
	private TipoVeiculoRepository tipoVService;

	@RequestMapping(value = "/tipov/all", method = RequestMethod.GET)
	public List<TipoVeiculo> getAllTipos() {
		System.out.println("Get ALl Tipos API");
		return tipoVService.findAll();
	}

	@RequestMapping(value = "/tipov/find/{id}", method = RequestMethod.GET)
	public TipoVeiculo getTipoVById(@PathVariable("id") long id) {
		System.out.println("Get Marca By Id API");
		TipoVeiculo tipoV = tipoVService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo Não Encontrado para esse id: " + id));

		if (tipoV == null) {
			return null;
		}
		return tipoV;

	}

	@RequestMapping(value = "/tipov/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTipoV(@PathVariable long id) {
		System.out.println("Delete Tipo API");
		tipoVService.deleteById(id);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@RequestMapping(value = "/tipov/create", method = RequestMethod.POST)
	public TipoVeiculo createTipoV(@Valid @RequestBody TipoVeiculo tipoV) {
		return tipoVService.save(tipoV);
	}

	@RequestMapping(value = "/tipov/update", method = RequestMethod.PUT)
	public TipoVeiculo updateTipoV(@Valid @RequestBody TipoVeiculo tipoV) {
		return tipoVService.save(tipoV);
	}

}
