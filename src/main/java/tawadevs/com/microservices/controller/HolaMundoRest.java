package tawadevs.com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tawadevs.com.microservices.configuration.ApplicationConfig;

@RestController
public class HolaMundoRest {
	
	@Autowired
	private ApplicationConfig appConfig;
	
	@GetMapping("/holaMundo")
	public String greetings () {
		
		System.out.println("APPCONFIG: " + appConfig.toString());
		return "Hola Mundo Rest :D";
	}

}
