package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;
import br.gov.sp.fatec.springbootapp.controller.View;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.sp.fatec.springbootapp.exception.RegistroNaoEncontradoException;

import br.gov.sp.fatec.springbootapp.entity.Cliente;
import br.gov.sp.fatec.springbootapp.entity.Pedido;
import br.gov.sp.fatec.springbootapp.repository.PedidoRepository;
import br.gov.sp.fatec.springbootapp.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;


//como o component => onde vai ter a regra de negócio
@Service("ClienteService")
public class ClienteServiceImpl implements ClienteService {

    // instancia o repositorio entao posso usar o rep direto
    @Autowired
    private PedidoRepository pedRepo;

    @Autowired
    private ClienteRepository cliRepo;

    //tudo o que ocorre é uma transação
    @Transactional
    public Cliente criarCliente(String nome, String email, Integer idade, String pedido, Integer valor) {
        
        Pedido ped = pedRepo.buscaPedidoPorNome(pedido);
        if(ped == null) {
            ped = new Pedido();
            ped.setNome(pedido);
            ped.setValor(valor);
            pedRepo.save(ped);
        }

        Cliente cli = new Cliente();
        cli.setNome(nome);
        cli.setEmail(email);
        cli.setIdade(idade);
        cli.setPedidos(new HashSet<Pedido>()); //pegando a lista de pedidos do cliente e atribuindo o pedido
        cli.getPedidos().add(ped);
        cliRepo.save(cli);
        return cli;
    }

    @Transactional
    public Cliente novoCliente(String nome, String email, Integer idade) {
        
        Cliente cli = new Cliente();
        cli.setNome(nome);
        cli.setEmail(email);
        cli.setIdade(idade);
        cliRepo.save(cli);
        return cli;
    }

    public List<Cliente> buscarClientes(){
        return cliRepo.findAll();
    }
    
    @Override
    public Cliente buscarClientePorId(Long id){
        Cliente clienteOp = cliRepo.buscarClientePorId(id);
        if(clienteOp != null) {
            return clienteOp;
        }
        throw new RegistroNaoEncontradoException("Cliente não encontrado!");
    }

    @Override
    public Cliente buscarClientePorNome(String nome){
        Cliente cliente = cliRepo.findByNome(nome);
        if(cliente != null) {
            return cliente;
        }
        throw new RegistroNaoEncontradoException("Cliente não encontrado!");
    }
        

    public Cliente atualizarCliente(String nome, String email, Integer idade, Long id){
        Cliente cliente = cliRepo.buscarClientePorId(id);
        if(cliente != null){
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setIdade(idade);
            cliRepo.save(cliente);

            return cliente;
        }

        throw new RegistroNaoEncontradoException("Cliente não encontrado!");
    }

    //PEDIDO


    @Override
    public Pedido buscaPedidoPorNome(String nome){
        Pedido pedido = pedRepo.findByNome(nome);
        if(pedido != null){
            return pedido;
        }
        throw new RegistroNaoEncontradoException("Pedido não encontrado");
    }

    @Transactional
    public Pedido criarPedido(String nome, Integer valor, Long id){
        Cliente cliente = cliRepo.buscarClientePorId(id);
        Pedido pedido = new Pedido();
        if(cliente != null){
            
            pedido.setNome(nome);
            pedido.setValor(valor);
            cliente.setPedidos(new HashSet<Pedido>());
            cliente.getPedidos().add(pedido);
            pedido.setClientes(cliente);
            pedRepo.save(pedido);
            cliRepo.save(cliente);   
            return pedido;      

        }               
        throw new RegistroNaoEncontradoException("Cliente não encontrado!");     
        
    }

        
}
