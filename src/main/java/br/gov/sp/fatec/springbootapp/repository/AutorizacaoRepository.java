package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNome(String autorizacao);
    
}