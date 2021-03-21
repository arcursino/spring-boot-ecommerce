package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Pedido;
import br.gov.sp.fatec.springbootapp.entity.Cliente;
import br.gov.sp.fatec.springbootapp.repository.PedidoRepository;
import br.gov.sp.fatec.springbootapp.repository.ClienteRepository;


@Service("ClienteService")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private PedidoRepository pedRepo;

    @Autowired
    private ClienteRepository cliRepo;

    @Transactional
    @Override
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
        cli.setPedidos(new HashSet<Pedido>());
        cli.getPedidos().add(ped);
        cliRepo.save(cli);
        return cli;
    }
    
}
