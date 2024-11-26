package br.com.etechoracio.pw3_study.controller;

import br.com.etechoracio.pw3_study.service.ConexaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/conexoes")
@CrossOrigin(origins = "*") //permite acesso a todas as portas (=>"*")
public class ConexaoController {
    @Autowired
    private ConexaoService service;
    @GetMapping
    private ResponseEntity<Long> contarConexoes(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.contar());
    }
}
