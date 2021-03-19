package br.gov.sp.fatec.springbootapp.service;

import br.gov.sp.fatec.springbootapp.entity.Cliente;

public interface SegurancaService {

    public Cliente criarCliente(String nome, String email, Integer idade, String pedido);
    
}
