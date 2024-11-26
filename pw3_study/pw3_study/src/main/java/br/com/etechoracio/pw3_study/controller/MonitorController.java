package br.com.etechoracio.pw3_study.controller;

import br.com.etechoracio.pw3_study.DTO.MonitorDTO;
import br.com.etechoracio.pw3_study.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitores")
@CrossOrigin(origins = "*")
public class MonitorController {
    @Autowired
    private MonitorService service;
    @GetMapping
    public ResponseEntity<List<MonitorDTO>> listarMonitores(){
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MonitorDTO> pegarMonitor(@PathVariable Long id){
        var resposta = service.buscar(id);
        if(resposta.isPresent()){
            return ResponseEntity.ok(resposta.get());
        }else
            return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<MonitorDTO> inserirMonitor(@RequestBody MonitorDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MonitorDTO> alterarMonitor(@PathVariable Long id, @RequestBody MonitorDTO body){
        var caixa = service.alterar(id,body);
        if(caixa.isPresent())
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(caixa.get());
        else
            return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MonitorDTO> deletarMonitor(@PathVariable Long id){
        var caixa = service.excluir(id);
        if(caixa.isPresent())
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(caixa.get());
        else
            return ResponseEntity.notFound().build();
    }
}
