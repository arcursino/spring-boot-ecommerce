package br.gov.sp.fatec.ecommerce.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import br.gov.sp.fatec.ecommerce.controller.View;

@Entity
@Table(name = "ped_pedido")
public class Pedido {
    
    //cria o id da tabela pedido chave unica
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long id;

    //cria a coluna nome do pedido
    @JsonView(View.ClienteResumo.class) 
    @Column(name = "ped_nome")
    private String nome;

    //cria a coluna valor do pedido
    @JsonView(View.ClienteResumo.class) 
    @Column(name = "ped_valor")
    private Integer valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cli_id")
    private Cliente cliente;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    
    public String getNome() {
        return this.nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }   

    public Integer getValor(){
        return this.valor;
    }

    public void setValor(Integer valor){
        this.valor = valor;
    }

   public Cliente getClientes() {
        return this.cliente;
    }

    public void setClientes (Cliente cliente) {
        this.cliente = cliente;
    }  
    
}