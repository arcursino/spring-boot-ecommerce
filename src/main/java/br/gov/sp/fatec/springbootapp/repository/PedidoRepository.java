package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import br.gov.sp.fatec.springbootapp.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    @Query("select p from Pedido p where p.nome = ?1")
    public Pedido buscaPedidoPorNome(String nome);

    @Query("select p from Pedido p where p.valor= ?2")
    public Pedido buscaPedidoPorValor(Integer valor);

    public Pedido findByNome(String nome);

    @Query("select p from  Pedido p where p.id = ?1 ")
    public Pedido buscarPedidoPorId(Long id);

}
