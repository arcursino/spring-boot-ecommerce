package br.gov.sp.fatec.springbootapp.service;

import br.gov.sp.fatec.springbootapp.entity.Cliente;
import br.gov.sp.fatec.springbootapp.entity.Pedido;
import java.util.List;

public interface ClienteService {
    
    public Cliente criarCliente(String nome, String email, Integer idade, String pedido, Integer valor);

    public List<Cliente> buscarClientes();    

    public Cliente buscarClientePorId(Long id);

    public Cliente buscarClientePorNome(String nome);

    public Cliente atualizarCliente(String nome, String email, Integer idade, Long id);

    public Cliente novoCliente(String nome, String email, Integer idade);

    //PEDIDO

    public Pedido criarPedido(String nome, Integer valor, Long id);

    public Pedido buscaPedidoPorNome(String nome);
    
    public List<Pedido> buscarPedidos();

    public Pedido buscarPedidoPorId(Long id);

    public Pedido atualizarValorPedido(Integer valor, Long id);
}
