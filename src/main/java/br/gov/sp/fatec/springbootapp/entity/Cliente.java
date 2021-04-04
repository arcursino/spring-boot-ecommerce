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
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cli_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long id;

    @Column(name = "cli_nome")
    private String nome;

    @Column(name = "cli_email")
    private String email;   

    @Column(name = "cli_idade")
    private Integer idade;   
    
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="clientes")
    @JsonIgnore    
    private Set<Pedido> pedidos;
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail (String email) {
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