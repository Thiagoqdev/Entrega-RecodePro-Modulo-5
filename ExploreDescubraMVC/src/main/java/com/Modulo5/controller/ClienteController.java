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

import com.Modulo5.entities.Cliente;
import com.Modulo5.repositories.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("clientes/index.html");

		List<Cliente> clientes = clienteRepository.findAll();
		modelAndView.addObject("clientes", clientes);

		return modelAndView;
	}

	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("clientes/create"); 

		modelAndView.addObject("cliente", new Cliente());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

		clienteRepository.save(cliente);

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("clientes/update");

        Cliente cliente = clienteRepository.getReferenceById(id);
        modelAndView.addObject("cliente", cliente);

        return modelAndView;
    }
	
	@PostMapping("/{id}/editar")
    public ModelAndView editar(Cliente cliente)  {

      
        clienteRepository.save(cliente);
        ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

        return modelAndView;
    }
	
	@GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

        clienteRepository.deleteById(id);

        return modelAndView;
    }
}
