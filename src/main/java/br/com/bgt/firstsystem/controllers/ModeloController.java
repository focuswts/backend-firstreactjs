package br.com.bgt.firstsystem.controllers;

import java.util.List;
import java.util.Optional;

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
import br.com.bgt.firstsystem.entities.Modelo;
import br.com.bgt.firstsystem.entities.TipoVeiculo;
import br.com.bgt.firstsystem.repository.MarcaRepository;
import br.com.bgt.firstsystem.repository.ModeloRepository;
import br.com.bgt.firstsystem.repository.TipoVeiculoRepository;

@RestController
@CrossOrigin("*")
public class ModeloController {

	@Autowired
	private TipoVeiculoRepository tipoVService;

	@Autowired
	private MarcaRepository marcaService;

	@Autowired
	private ModeloRepository modeloService;

	@RequestMapping(value = "/modelo/all", method = RequestMethod.GET)
	public List<Modelo> getAllModelos() {
		System.out.println("Get ALl Modelos API");
		return modeloService.findAll();
	}

	@RequestMapping(value = "/modelo/find/{id}", method = RequestMethod.GET)
	public Modelo getModeloById(@PathVariable long id) {
		System.out.println("Get Modelo By Id API");
		Modelo modelo = modeloService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Modelo Não Encontrado para esse id: " + id));

		if (modelo == null) {
			return null;
		}
		return modelo;
	}

	@RequestMapping(value = "/modelo/find/marca/id/{id}", method = RequestMethod.GET)
	public List<Modelo> getMarcaModeloById(@PathVariable long id) throws Exception {
		System.out.println("Get Marca Modelo By Id API");

		List<Modelo> modelosList = modeloService.findAllByMarcaId(id);

		if (modelosList.size() == 0) {
			System.out.println("Vazio");
			return null;
		}

		return modelosList;

	}

	@RequestMapping(value = "/modelo/find/marca/desc/{desc}", method = RequestMethod.GET)
	public List<Modelo> getMarcaModeloByCpf(@PathVariable String desc) {
		System.out.println("Get Marca Modelo By Desc API");

		List<Modelo> modelos = modeloService.findAllByMarcaDesc(desc);

		if (modelos.size() == 0) {
			return null;
		}
		return modelos;
	}

	@RequestMapping(value = "/modelo/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteModelo(@PathVariable long id) {
		System.out.println("Delete Modelo API");
		modeloService.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/modelo/create", method = RequestMethod.POST)
	public Modelo createModelo(@Valid @RequestBody Modelo modelo) {
		Optional<Marca> marca = marcaService.findById(modelo.getIdMarca().getId());
		Optional<TipoVeiculo> tipoV = tipoVService.findById(modelo.getIdTipoVeiculo().getId());

		if (marca.isPresent() && tipoV.isPresent()) {
			modelo.setIdTipoVeiculo(tipoV.get());
			modelo.setIdMarca(marca.get());
			return modeloService.save(modelo);
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/modelo/update", method = RequestMethod.PUT)
	public Modelo updateModelo(@Valid @RequestBody Modelo modelo) {
		Optional<Marca> marca = marcaService.findById(modelo.getIdMarca().getId());
		Optional<TipoVeiculo> tipoV = tipoVService.findById(modelo.getIdTipoVeiculo().getId());

		if (marca.isPresent() && tipoV.isPresent()) {
			modelo.setIdMarca(marca.get());
			modelo.setIdTipoVeiculo(tipoV.get());
			return modeloService.save(modelo);
		} else {
			return null;
		}
	}

}
