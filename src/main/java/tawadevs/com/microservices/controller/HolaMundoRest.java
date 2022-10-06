package tawadevs.com.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoRest {
	
	@GetMapping("/holaMundo")
	public String greetings () {
		return "Hola Mundo Rest :D";
	}

}
