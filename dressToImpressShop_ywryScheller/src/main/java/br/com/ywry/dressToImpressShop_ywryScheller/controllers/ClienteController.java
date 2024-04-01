package br.com.ywry.dressToImpressShop_ywryScheller.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ywry.dressToImpressShop_ywryScheller.repositories.ClienteRepository;
import br.com.ywry.dressToImpressShop_ywryScheller.model.Cliente;

@Controller
@RequestMapping("/")
public class ClienteController {
    
    @Autowired
    ClienteRepository clienteRepo;

    public ClienteController(ClienteRepository clienteRepo){
        this.clienteRepo = clienteRepo;
    }

    @GetMapping
    public String index(){
        return "index.html";
    }

    @GetMapping("/listarClientes")
    public ModelAndView listarClientes(){
        List<Cliente> todosOsClientes = clienteRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("listarClientes");
        modelAndView.addObject("todosOsClientes", todosOsClientes);
        return modelAndView;
    }
}
