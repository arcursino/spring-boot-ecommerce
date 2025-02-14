package br.gov.sp.fatec.springbootapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootapp.security.JwtUtils;
import br.gov.sp.fatec.springbootapp.security.Login;
import br.gov.sp.fatec.springbootapp.service.ClienteService;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

  @Autowired
  private AuthenticationManager authManager;

  @Autowired
  private ClienteService clienteService;


  @PostMapping()
  public Login autenticar(@RequestBody Login login) throws JsonProcessingException {
    Authentication auth = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());    
    String aut = clienteService.buscarAutorizacaoUsuario(login.getUsername());   
    auth = authManager.authenticate(auth);

    login.setPassword(null);
    login.setAutorizacao(aut);
    login.setToken(JwtUtils.generateToken(auth));

    return login;
  }

}
