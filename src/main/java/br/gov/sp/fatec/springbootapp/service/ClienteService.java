package br.gov.sp.fatec.springbootapp.service;

import java.util.List;

import br.gov.sp.fatec.springbootapp.entity.Cliente;
import br.gov.sp.fatec.springbootapp.entity.Pedido;

import br.gov.sp.fatec.springbootapp.repository.ClienteRepository;


public interface ClienteService {

    public Cliente criarCliente(String nome, String email, Integer idade, String pedido, Integer valor);
    
    public List<Cliente> buscarTodosClientes();
    
    public Cliente buscarClientePorId(Long id);

    public Cliente buscaClientePorNome(String nome);
    
}
