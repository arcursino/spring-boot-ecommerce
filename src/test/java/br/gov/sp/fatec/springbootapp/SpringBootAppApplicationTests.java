package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Cliente;
import br.gov.sp.fatec.springbootapp.entity.Pedido;
import br.gov.sp.fatec.springbootapp.repository.ClienteRepository;
import br.gov.sp.fatec.springbootapp.repository.PedidoRepository;
import br.gov.sp.fatec.springbootapp.service.ClienteService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private ClienteRepository cliRepo;

    @Autowired
    private PedidoRepository pedRepo;

    @Autowired
    private ClienteService cliService;


	@Test
	void contextLoads() {
    }

   
    @Test
    void testaInsercao() {
        Cliente cli = new Cliente();
        cli.setNome("Ariana3");
        cli.setEmail("ariana3@ariana.com");
        cli.setIdade(39);
        cli.setPedidos(new HashSet<Pedido>());
        Pedido ped = new Pedido();
        ped.setNome("pedido03");
        ped.setValor(200);
        pedRepo.save(ped);
        cli.getPedidos().add(ped);
        cliRepo.save(cli);  
        assertNotNull(cli.getId());     

    }

    @Test
    void testaPedido() {
        Cliente cli = cliRepo.findById(1L).get();         
        assertEquals("pedido01", cli.getPedidos().iterator().next().getNome());     

    }

   
/*
    @Test
    void testaCliente() {
        Pedido ped = pedRepo.findById(1L).get();         
        assertEquals("Ariana", ped.getCliente().iterator().next().getNome());     

    } 
*/  

    @Test
    void testaBuscaClienteNomeEmailQuery() {
        Cliente cli = cliRepo.buscaClientePorNomeEmail("Ariana", "ariana@ariana.com");
        assertNotNull(cli);    

    }

    @Test
    void testaBuscaClienteNomeQuery() {
        Cliente cli = cliRepo.buscaClientePorNome("Ariana");
        assertNotNull(cli);    

    } 

    @Test
    void testaBuscaClienteNomePedidoQuery() {
        List<Cliente> cliente = cliRepo.buscaClientePorNomePedido("pedido01");
        assertFalse(cliente.isEmpty());    

    }
/*
    @Test
    void testaServicoCriaCliente(){
        Cliente cli = cliService.criarCliente("Ariana4", "ariana4@ariana.com", 37, "pedido04", 400);
        assertNotNull(cli);
    }  */  

}
