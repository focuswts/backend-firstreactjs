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

import br.com.bgt.firstsystem.entities.Cidade;
import br.com.bgt.firstsystem.entities.Endereco;
import br.com.bgt.firstsystem.entities.Mensalista;
import br.com.bgt.firstsystem.repository.CidadeRepository;
import br.com.bgt.firstsystem.repository.EnderecoRepository;
import br.com.bgt.firstsystem.repository.MensalistaRepository;

@RestController
@CrossOrigin("*")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoService;

	@Autowired
	private MensalistaRepository mensalistaService;

	@Autowired
	private CidadeRepository cidadeService;

	@RequestMapping(value = "/endereco/all", method = RequestMethod.GET)
	public List<Endereco> getAllEndereco() {
		System.out.println("Get ALl Endereco API");
		return enderecoService.findAll();
	}

	@RequestMapping(value = "/endereco/find/{id}", method = RequestMethod.GET)
	public Endereco getEnderecoById(@PathVariable long id) {
		System.out.println("Get Endereco By Id API");
		Endereco endereco = enderecoService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Endereco Não Encontrado para esse id: " + id));

		if (endereco == null) {
			return null;
		}
		return endereco;
	}

	@RequestMapping(value = "/endereco/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEndereco(@PathVariable long id) {
		System.out.println("Delete Endereco API");
		enderecoService.deleteById(id);
		String response = "success";
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/endereco/create", method = RequestMethod.POST)
	public Endereco createEndereco(@Valid @RequestBody Endereco endereco) {

		Optional<Mensalista> mensalistaOptional = mensalistaService.findById(endereco.getIdMensalista().getId());
		Optional<Cidade> cidadeOptional = cidadeService.findById(endereco.getIdCidade().getId());

		if (mensalistaOptional.isPresent() && cidadeOptional.isPresent()) {

			endereco.setIdMensalista(mensalistaOptional.get());
			endereco.setIdCidade(cidadeOptional.get());

			return enderecoService.save(endereco);
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/endereco/update", method = RequestMethod.PUT)
	public Endereco updateEndereco(@Valid @RequestBody Endereco endereco) {
		Optional<Mensalista> mensalistaOptional = mensalistaService.findById(endereco.getIdMensalista().getId());
		Optional<Cidade> cidadeOptional = cidadeService.findById(endereco.getIdCidade().getId());

		if (mensalistaOptional.isPresent() && cidadeOptional.isPresent()) {

			endereco.setIdMensalista(mensalistaOptional.get());
			endereco.setIdCidade(cidadeOptional.get());

			return enderecoService.save(endereco);
		} else {
			return null;
		}
	}

}
