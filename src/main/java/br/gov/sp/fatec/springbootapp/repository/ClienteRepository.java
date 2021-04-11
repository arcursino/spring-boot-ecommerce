package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootapp.entity.Cliente;

//<Cliente, Long> indica a entidade e o tipo da chave primária
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    //=?1 coluna 1
    @Query("select c from Cliente c where c.nome =?1")
    public Cliente buscaClientePorNome(String nome);
    //=?2 coluna 2
    @Query("select c from Cliente c where c.nome =?1 and c.email = ?2")
    public Cliente buscaClientePorNomeEmail(String nome, String email);

    @Query("select c from Cliente c inner join c.pedidos p where p.nome = ?1")
    public List<Cliente> buscaClientePorNomePedido(String pedido);

    @Query("select c from  Cliente c where c.id = ?1 ")
    public Cliente buscarClientePorId(Long id);

    public Cliente findByNome(String nome);

}
