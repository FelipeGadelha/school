package br.com.portfolio.rasmoo.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matter")
public class HelloController {

	@GetMapping
	public ResponseEntity<String> hello() {
		return ResponseEntity.status(HttpStatus.OK).body("fala dev");
	}
	
	
}
