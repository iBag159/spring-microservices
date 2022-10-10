package tawadevs.com.microservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import tawadevs.com.microservices.model.AccountDTO;
import tawadevs.com.microservices.model.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
		System.out.println("Getting user by its ID");
		//UserDTO user = new UserDTO(1, "Un nombre kawai");
		UserDTO user = null;
		//user.setLastName("Apellido");
		//user.setAge(31);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		UserDTO user1 = new UserDTO(1, "Un nombre kawai");
		UserDTO user2 = new UserDTO(2, "Otro");
		UserDTO user3 = new UserDTO(3, "Nuevo");
		return ResponseEntity.ok(List.of(user1, user2, user3));
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserDTO user) {
		System.out.println("Creatting a new user " + user.getName());
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/{id}")
						.buildAndExpand(user.getId())
						.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO user) {
		System.out.println("Editing an existing user");
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		System.out.println("Deleting an existing user");
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/{id}/accounts")
	public ResponseEntity<List<AccountDTO>> getAllUserAccounts(@PathVariable Integer id) {
		System.out.println("Getting all user accounts");
		List<AccountDTO> accounts = List.of(new AccountDTO(1, "Google"), new AccountDTO(2, "Facebook"), new AccountDTO(3, "Twitter"));
		return ResponseEntity.ok(accounts);
	}
	
	@GetMapping("/{id}/accounts/{idAccount}")
	public ResponseEntity<AccountDTO> getUserAccount(@PathVariable Integer id, @PathVariable Integer idAccount) {
		List<AccountDTO> accounts = List.of(new AccountDTO(1, "Google"), new AccountDTO(2, "Facebook"), new AccountDTO(3, "Twitter"));
		if(idAccount > accounts.size()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(accounts.get(idAccount - 1));
	}
}
