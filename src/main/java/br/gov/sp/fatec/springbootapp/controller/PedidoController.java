package br.gov.sp.fatec.springbootapp.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.sp.fatec.springbootapp.entity.Pedido;
import br.gov.sp.fatec.springbootapp.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.springbootapp.repository.PedidoRepository;
import br.gov.sp.fatec.springbootapp.service.ClienteService;

//metodos que estiverem aqui podem ser rotas (serviços)
@RestController
// permite acesso externo de qualquer lugar se não colocar as origens.
@RequestMapping(value = "/pedido")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {

    @Autowired
    private PedidoRepository pedRepo;

    @Autowired
    private ClienteService clienteService;

    @JsonView(View.PedidoResumo.class)
    @GetMapping(value = "/id/{id}")
    public Pedido buscarPedidoPorId(@PathVariable("id") Long id) {
        return clienteService.buscarPedidoPorId(id);
    }

    @JsonView(View.PedidoResumo.class)
    @GetMapping
    public List<Pedido> buscarPedidos() {
        return clienteService.buscarPedidos();
    }

    @JsonView(View.PedidoResumo.class)
    @GetMapping(value = "/nome")
    public Pedido buscaPedidoPorNome(@RequestParam(value = "nome") String nome) {
        return clienteService.buscaPedidoPorNome(nome);
    }

    @JsonView(View.PedidoResumo.class)
    @PostMapping("/")
    public ResponseEntity<Pedido> cadastrarNovoPedido(@RequestBody Pedido pedido,
        UriComponentsBuilder uriComponentsBuilder) throws Exception {

        pedido = clienteService.criarPedido(pedido.getNome(), pedido.getValor(), pedido.getId());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/pedido/id/" + pedido.getId()).build().toUri());

       return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
    }


    @DeleteMapping("/id/{id}")
    public String deletePedido(@PathVariable(value = "id") Long id) {
        Pedido pedido = pedRepo.buscarPedidoPorId(id);
        if (pedido != null) {
            pedRepo.delete(pedido);
            return "Pedido excluído com sucesso";
        }
        throw new RegistroNaoEncontradoException("Pedido não encontrado!");
    }

    @JsonView(View.PedidoResumo.class)
    @PutMapping("/id/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido,
            UriComponentsBuilder uriComponentsBuilder) throws Exception {

        pedido = clienteService.atualizarValorPedido(pedido.getValor(), id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/pedido/id/" + pedido.getId()).build().toUri());

        return new ResponseEntity<Pedido>(pedido, responseHeaders, HttpStatus.CREATED);
    }

}