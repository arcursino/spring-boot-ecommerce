package br.gov.sp.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootapp.controller.View;

@Entity
@Table(name = "cli_cliente")
public class Cliente {

    //gera o id da tabela cliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.ClienteCompleto.class) 
    @Column(name = "cli_id")
    private Long id;

    @JsonView({View.ClienteResumo.class, View.PedidoResumo.class}) 
    @Column(name = "cli_nome")
    private String nome;

    @JsonView(View.ClienteResumo.class) 
    @Column(name = "cli_email")
    private String email;

    @JsonView(View.ClienteResumo.class) 
    @Column(name = "cli_idade")
    private Integer idade;

    
    @JsonView(View.ClienteResumo.class) 
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public Integer getIdade() {
        return this.idade;
    }

    public void setIdade (Integer idade) {
        this.idade = idade;
    }

    public Set<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos (Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
}