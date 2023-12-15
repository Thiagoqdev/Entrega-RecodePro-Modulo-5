package com.Modulo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {


	@GetMapping({"/", "index"})
	public String home () {
		return "index";
	}
	
	@GetMapping("/Destinos")
	public String destino () {
		return "Destinos";
	}
	
	@GetMapping("/Promoções")
	public String promocoes () {
		return "Promoções";
	}
	
	@GetMapping("/Cadastro")
	public String cadastro () {
		return "Cadastro";
	}
	
	@GetMapping("/Contato")
	public String contato () {
		return "Contato";
	}
		
	@GetMapping("/compras/index")
	public String compras () {
		return "compras/index";
	}
	
	
	@GetMapping("/pacotes/index")
	public String pacotes () {
		return "pacotes/index";
	}
	
	
}

