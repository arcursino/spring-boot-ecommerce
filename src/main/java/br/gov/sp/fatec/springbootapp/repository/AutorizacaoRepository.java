package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootapp.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    
    /*
    @Query("select a from Autorizacao a where a.nome =?1")
    public Autorizacao buscaAutorizacaoPorNome(String nome);*/

    public Autorizacao findByNome(String autorizacao);
    
}