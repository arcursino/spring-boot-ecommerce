package br.gov.sp.fatec.springbootapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

  @GetMapping
  public String welcome() {
    return "Bem vindo ao Sistema de Controle de Pedidos e Clientes Ecommerce!";
  }
  
}