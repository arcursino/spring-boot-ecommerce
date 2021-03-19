package br.gov.sp.fatec.springbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Pedido;
import br.gov.sp.fatec.springbootapp.entity.Cliente;
import br.gov.sp.fatec.springbootapp.repository.PedidoRepository;
import br.gov.sp.fatec.springbootapp.repository.ClienteRepository;
import br.gov.sp.fatec.springbootapp.service.SegurancaService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private ClienteRepository cliRepo;

    @Autowired
    private PedidoRepository pedRepo;

    @Autowired
    private SegurancaService segService;


	@Test
	void contextLoads() {
    }
    
    @Test
    void testaInsercao() {
        Cliente cli = new Cliente();
        cli.setNome("Ariana2");
        cli.setEmail("ariana@ariana.com");
        cli.setIdade(39);
        cli.setPedidos(new HashSet<Pedido>());
        Pedido ped = new Pedido();
        ped.setNome("Pedido02");
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

    @Test
    void testaCliente() {
        Pedido ped = pedRepo.findById(1L).get();         
        assertEquals("Ariana", ped.getClientes().iterator().next().getNome());     

    }    

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
        List<Cliente> clientes = cliRepo.buscaClientePorNomePedido("pedido01");
        assertFalse(clientes.isEmpty());    

    }

    @Test
    void testaServicoCriaCliente(){
        Cliente cli = segService.criarCliente("Ariana", "ariana@ariana.com", 37, "pedido01");
        assertNotNull(cli);
    }

}
