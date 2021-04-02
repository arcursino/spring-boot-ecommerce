package br.gov.sp.fatec.springbootapp.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.sp.fatec.springbootapp.entity.Pedido;
import br.gov.sp.fatec.springbootapp.entity.Cliente;
import br.gov.sp.fatec.springbootapp.service.ClienteService;
import br.gov.sp.fatec.springbootapp.repository.ClienteRepository;




@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin //Permite acesso de sites externos
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodosClientes();
    }

    @GetMapping(value = "/{id}")
    public Cliente buscarPorId(@PathVariable("id") Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @GetMapping(value = "/{nome}")
    public Cliente buscaClientePorNome(String nome){
        return ClienteRepository.buscaClientePorNome(String nome);
    }



}
