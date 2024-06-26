package br.com.projeto.pizzaria3d.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

	@GetMapping("test")
	public String getTest() {
		return "Envie uma mensagem!";
	}
	
	@GetMapping("message")
	public String getMessage() {
		return "Outra mensagem!";
	}
	
	@GetMapping("send")
	public String getSend() {
		return "Mensagem final!";
	}
	
}
