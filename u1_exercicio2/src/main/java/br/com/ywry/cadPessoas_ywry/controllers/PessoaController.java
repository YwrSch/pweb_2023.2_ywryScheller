package br.com.ywry.cadPessoas_ywry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ywry.cadPessoas_ywry.model.Pessoa;
import br.com.ywry.cadPessoas_ywry.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepo;

    public PessoaController(PessoaRepository pessoaRepo) {
        this.pessoaRepo = pessoaRepo;
    }

    @GetMapping
    public String index() {
        return "index.html";
    }

    @GetMapping("/listarPessoas")
    public ModelAndView listarPessoas() {
        List<Pessoa> todasAsPessoas = pessoaRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("listarPessoas");
        modelAndView.addObject("todasAsPessoas", todasAsPessoas);
        return modelAndView;
    }

    @GetMapping("/adcionarPessoa")
    public ModelAndView adcionarPessoaForm() {
        ModelAndView modelAndView = new ModelAndView("adcionarPessoa");
        modelAndView.addObject(new Pessoa());
        return modelAndView;
    }

    @PostMapping("/adcionarPessoa")
    public String adcionarPessoa(Pessoa p) {
        this.pessoaRepo.save(p);
        return "redirect:/listarPessoas";
    }

    @GetMapping("/remover/{id}")
    public ModelAndView removerPessoa(@PathVariable("id") long id){
        Pessoa aRemover = pessoaRepo.findById(id).orElseThrow(()->new IllegalArgumentException("ID Inválido: " + id));
        pessoaRepo.delete(aRemover);
        return new ModelAndView("redirect:/listarPessoas");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarPessoaForm(@PathVariable("id") long id){
        Pessoa aEditar = pessoaRepo.findById(id).orElseThrow(()->new IllegalArgumentException("ID Inválido: " + id));
        ModelAndView modelAndView = new ModelAndView("editarPessoa");
        modelAndView.addObject(aEditar);
        return modelAndView;
    }

    @PostMapping("/editar/{id}")
    public String editarPessoa(@PathVariable("id") long id, Pessoa p){
        this.pessoaRepo.save(p);
        return "redirect:/listarPessoas";
    }
}
