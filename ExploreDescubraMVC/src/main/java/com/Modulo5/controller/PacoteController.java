package com.Modulo5.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Modulo5.entities.Pacote;
import com.Modulo5.repositories.PacoteRepository;

@Controller
@RequestMapping("/pacotes")
public class PacoteController {

	@Autowired
	private PacoteRepository pacoteRepository;

	// lista todos os dados do banco pacotes
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("pacotes/index.html");

		List<Pacote> pacotes = pacoteRepository.findAll();
		modelAndView.addObject("pacotes", pacotes);

		return modelAndView;
	}

	@GetMapping("/cadastrar") //Metodo
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("pacotes/create"); //url na qual ira ser direcionado

		modelAndView.addObject("pacote", new Pacote());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Pacote pacote) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");

		pacoteRepository.save(pacote);

		return modelAndView;
	}
	
	@GetMapping("/{idPacote}/editar")
    public ModelAndView editar(@PathVariable Long idPacote) {
        ModelAndView modelAndView = new ModelAndView("pacotes/update");

        Pacote pacote = pacoteRepository.getReferenceById(idPacote);
        modelAndView.addObject("pacote", pacote);

        return modelAndView;
    }
	
	@PostMapping("/{idPacote}/editar")
    public ModelAndView editar(Pacote pacote)  {

      
        pacoteRepository.save(pacote);
        ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");

        return modelAndView;
    }
	
	@GetMapping("/{idPacote}/excluir")
    public ModelAndView excluir(@PathVariable Long idPacote) {
        ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");

        pacoteRepository.deleteById(idPacote);

        return modelAndView;
    }
}
