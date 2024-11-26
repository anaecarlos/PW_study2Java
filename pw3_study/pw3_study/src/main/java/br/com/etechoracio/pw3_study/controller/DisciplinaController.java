package br.com.etechoracio.pw3_study.controller;

import br.com.etechoracio.pw3_study.DTO.DisciplinaResponseDTO;
import br.com.etechoracio.pw3_study.entity.Disciplina;
import br.com.etechoracio.pw3_study.repository.DisciplinaRepository;
import br.com.etechoracio.pw3_study.service.DisciplinaService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@CrossOrigin(origins = "*") //determina quais portas (ou nome de dominio) estão aptos a serem usados
public class DisciplinaController {
    @Autowired
    private DisciplinaService service;

    @GetMapping
    public List<DisciplinaResponseDTO> listar(){
        return service.listar();
    }
    @GetMapping("/{id}")
    public DisciplinaResponseDTO getDisciplinaById(@PathVariable Long id){
        return service.pegarPorId(id);
    }
    @PostMapping
    public void postDisciplina(@RequestBody Disciplina disciplina){
        service.inserir(disciplina);
    }
    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina){
        service.atualizar(id,disciplina);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletarPorId(id);
    }
}
