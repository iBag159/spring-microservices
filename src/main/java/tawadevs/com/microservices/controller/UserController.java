package tawadevs.com.microservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tawadevs.com.microservices.model.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("/{id}")
	public UserDTO getUserById(@PathVariable Integer id) {
		System.out.println("Getting user by its ID");
		UserDTO user = new UserDTO(1, "Un nombre kawai");
		user.setLastName("Apellido");
		user.setAge(31);
		return user;
	}
	
	@GetMapping
	public List<UserDTO> getAllUsers() {
		UserDTO user1 = new UserDTO(1, "Un nombre kawai");
		UserDTO user2 = new UserDTO(2, "Otro");
		UserDTO user3 = new UserDTO(3, "Nuevo");
		return List.of(user1, user2, user3);
	}
	
	@PostMapping
	public String createUser(@RequestBody UserDTO user) {
		System.out.println("Creatting a new user " + user.getName());
		return "http://localhost:8080/users/" + user.getId();
	}
	
	@PutMapping
	public UserDTO editUser(@RequestBody UserDTO user) {
		System.out.println("Editing an existing user");
		return user;
	}
	
	@DeleteMapping
	public void deleteUser(@PathVariable Integer id) {
		System.out.println("Deleting an existing user");
	}
}
