package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    public Pedido findByNome(String pedido);
}
