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
import com.Modulo5.entities.Compra;
import com.Modulo5.entities.Pacote;
import com.Modulo5.repositories.ClienteRepository;
import com.Modulo5.repositories.CompraRepository;
import com.Modulo5.repositories.PacoteRepository;

@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PacoteRepository pacoteRepository; // Adicionado o repositório de pacotes

    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("compras/index");

        List<Compra> compras = compraRepository.findAll();
        modelAndView.addObject("compras", compras);

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("compras/create");

        List<Cliente> clientes = clienteRepository.findAll();
        List<Pacote> pacotes = pacoteRepository.findAll(); // Obter a lista de pacotes

        modelAndView.addObject("clientes", clientes);
        modelAndView.addObject("pacotes", pacotes); // Adicionar a lista de pacotes ao modelo

        modelAndView.addObject("compra", new Compra());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Compra compra) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/compras");
        compraRepository.save(compra);
        return modelAndView;
    }
    
	@GetMapping("/{idCompra}/editar")
    public ModelAndView editar(@PathVariable Long idCompra) {
        ModelAndView modelAndView = new ModelAndView("compras/update");

        Compra compra = compraRepository.getReferenceById(idCompra);
        modelAndView.addObject("compra", compra);
        
        List<Cliente> clientes = clienteRepository.findAll();
        List<Pacote> pacotes = pacoteRepository.findAll();

        modelAndView.addObject("compra", compra);
        modelAndView.addObject("clientes", clientes);
        modelAndView.addObject("pacotes", pacotes);

        return modelAndView;
    }
	
	@PostMapping("/{idCompra}/editar")
    public ModelAndView editar(Compra compra)  {

      
        compraRepository.save(compra);
        ModelAndView modelAndView = new ModelAndView("redirect:/compras");

        return modelAndView;
    }
	
	@GetMapping("/{idCompra}/excluir")
    public ModelAndView excluir(@PathVariable Long idCompra) {
        ModelAndView modelAndView = new ModelAndView("redirect:/compras");

        compraRepository.deleteById(idCompra);

        return modelAndView;
    }
}

