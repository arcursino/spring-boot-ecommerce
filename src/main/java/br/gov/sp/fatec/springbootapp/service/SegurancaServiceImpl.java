package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Pedido;
import br.gov.sp.fatec.springbootapp.entity.Cliente;
import br.gov.sp.fatec.springbootapp.repository.PedidoRepository;
import br.gov.sp.fatec.springbootapp.repository.ClienteRepository;


@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private PedidoRepository pedRepo;

    @Autowired
    private ClienteRepository cliRepo;

    @Transactional
    @Override
    public Cliente criarCliente(String nome, String email, Integer idade, String pedido) {
        Pedido ped = pedRepo.findByNome(pedido);
        if(ped == null) {
            ped = new Pedido();
            ped.setNome(pedido);
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
