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
@Table(name = "aut_autorizacao")
public class Autorizacao {

    @JsonView(View.ClienteCompleto.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;

    @JsonView({View.ClienteResumo.class, View.AutorizacaoResumo.class})
    @Column(name = "aut_nome")
    private String nome;

    @JsonView(View.AutorizacaoResumo.class)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autorizacoes")
    private Set<Cliente> clientes;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}