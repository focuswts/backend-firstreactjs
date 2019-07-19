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

import br.com.bgt.firstsystem.entities.Mensalista;
import br.com.bgt.firstsystem.entities.Telefone;
import br.com.bgt.firstsystem.repository.MensalistaRepository;
import br.com.bgt.firstsystem.repository.TelefoneRepository;

@RestController
@CrossOrigin("*")
public class TelefoneController {

	@Autowired
	private TelefoneRepository telefoneService;

	@Autowired
	private MensalistaRepository mensalistaService;

	@RequestMapping(value = "/telefone/all", method = RequestMethod.GET)
	public List<Telefone> getAllTelefones() {
		System.out.println("Get ALl Telefones API");
		return telefoneService.findAll();
	}

	@RequestMapping(value = "/telefone/find/{id}", method = RequestMethod.GET)
	public Telefone getTelefoneById(@PathVariable long id) {
		System.out.println("Get Telefone By Id API");
		Telefone telefone = telefoneService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Telefone Não Encontrado para esse id: " + id));

		if (telefone == null) {
			return null;
		}
		return telefone;
	}

	@RequestMapping(value = "/telefone/find/mensalista/id/{id}", method = RequestMethod.GET)
	public List<Telefone> getTelefoneMensalistaById(@PathVariable long id) throws Exception {
		System.out.println("Get Telefone Mensalista By Id API");

		List<Telefone> telefonesList = telefoneService.findAllByMensalistaId(id);

		if (telefonesList.size() == 0) {
			System.out.println("Vazio");
			return null;
		}

		return telefonesList;

	}

	@RequestMapping(value = "/telefone/find/mensalista/cpf/{cpf}", method = RequestMethod.GET)
	public List<Telefone> getTelefoneMensalistaByCpf(@PathVariable String cpf) {
		System.out.println("Get Telefone Mensalista By CPF API");

		List<Telefone> telefones = telefoneService.findAllByMensalistaCpf(cpf);

		if (telefones.size() == 0) {
			return null;
		}
		return telefones;
	}

	@RequestMapping(value = "/telefone/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTelefone(@PathVariable long id) {
		System.out.println("Delete Telefone API");
		telefoneService.deleteById(id);
		String response = "success";
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/telefone/create", method = RequestMethod.POST)
	public Telefone createTelefone(@Valid @RequestBody Telefone telefone) {
		Optional<Mensalista> mensalista = mensalistaService.findById(telefone.getIdMensalista().getId());

		if (mensalista.isPresent()) {

			telefone.setIdMensalista(mensalista.get());
			return telefoneService.save(telefone);
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/telefone/update", method = RequestMethod.PUT)
	public Telefone updateTelefone(@Valid @RequestBody Telefone telefone) {
		return telefoneService.save(telefone);
	}

}
