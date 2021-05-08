package br.gov.sp.fatec.springbootapp.service;

import br.gov.sp.fatec.springbootapp.entity.Cliente;
import br.gov.sp.fatec.springbootapp.entity.Pedido;
import br.gov.sp.fatec.springbootapp.entity.Autorizacao;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface ClienteService extends UserDetailsService {
    
    public Cliente criarCliente(String nome, String senha, String email, Integer idade, String autorizacao);

    public List<Cliente> buscarClientes();    

    public Cliente buscarClientePorId(Long id);

    public Cliente buscarClientePorNome(String nome);

    public Cliente atualizarCliente(String nome, String senha, String email, Integer idade, Long id);

    public Cliente novoCliente(String nome, String senha, String email, Integer idade);

    //PEDIDO

    public Pedido criarPedido(String nome, Integer valor, Long id);

    public Pedido buscaPedidoPorNome(String nome);
    
    public List<Pedido> buscarPedidos();

    public Pedido buscarPedidoPorId(Long id);

    public Pedido atualizarValorPedido(Integer valor, Long id);

    //AUTORIZAÇÃO
    public Autorizacao buscarAutorizacaoPorNome(String nome);

    //public Autorizacao findByNome(String nome);

}
