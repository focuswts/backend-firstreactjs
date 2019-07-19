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

import br.com.bgt.firstsystem.entities.Usuario;
import br.com.bgt.firstsystem.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioService;

	@RequestMapping(value = "/usuario/all", method = RequestMethod.GET)
	public List<Usuario> getAllUsuarios() {
		System.out.println("Get ALl Usuarios API");
		return usuarioService.findAll();
	}

	@RequestMapping(value = "/usuario/find/{id}", method = RequestMethod.GET)
	public Usuario getUsuarioById(@PathVariable("id") long id) {
		System.out.println("Get Usuario By Id API");
		Usuario usuario = usuarioService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario Não Encontrado para esse id: " + id));

		if (usuario == null) {
			return null;
		}
		return usuario;

	}

	@RequestMapping(value = "/usuario/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUsuario(@PathVariable long id) {
		System.out.println("Delete Usuario API");
		usuarioService.deleteById(id);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@RequestMapping(value = "/usuario/create", method = RequestMethod.POST)
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@RequestMapping(value = "/usuario/update", method = RequestMethod.PUT)
	public Usuario updateUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

}
