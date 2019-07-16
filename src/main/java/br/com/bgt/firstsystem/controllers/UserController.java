package br.com.bgt.firstsystem.controllers;

import br.com.bgt.firstsystem.entities.User;
import br.com.bgt.firstsystem.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRepository userService;

	@RequestMapping(value = "/users/all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		System.out.println("Get ALl Users API");
		return userService.findAll();
	}

	@RequestMapping(value = "/users/find/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable long id) {
		System.out.println("Get User By Id API");
		User user = userService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário Não Encontrado para esse id: " + id));

		if (user == null) {
			return null;
		}
		return user;

	}

	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		System.out.println("Delete User API");
		userService.deleteById(id);

		String response = "success";

		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@RequestMapping(value = "/users/create", method = RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	public User updateUser(@Valid @RequestBody User user) {
		// System.out.println("Update User: " + user.getUsername() );
		return userService.save(user);
	}

}
