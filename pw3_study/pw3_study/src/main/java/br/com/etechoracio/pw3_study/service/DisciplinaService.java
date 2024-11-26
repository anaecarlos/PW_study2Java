package br.com.etechoracio.pw3_study.service;

import br.com.etechoracio.pw3_study.DTO.DisciplinaResponseDTO;
import br.com.etechoracio.pw3_study.entity.Disciplina;
import br.com.etechoracio.pw3_study.repository.DisciplinaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {
    @Autowired //injeção de dependencia; digo que o spring que vai instanciar o serviço
    private DisciplinaRepository repository;
    private ModelMapper modelMapper = new ModelMapper();
    public List<DisciplinaResponseDTO> listar(){
        var disciplinas = repository.findAll();
        var resultado = disciplinas.stream().map(
                e->modelMapper.map(e, DisciplinaResponseDTO.class))
                .collect(Collectors.toList());
        return resultado;
    }
    public DisciplinaResponseDTO pegarPorId(Long id){
        var caixa = repository.findById(id);
        DisciplinaResponseDTO dto;
        if(!caixa.isEmpty()) {
            dto = caixa.map(e->modelMapper.map(e,DisciplinaResponseDTO.class)).get();
        }else dto = null;
        return dto;
    }
    public void inserir(Disciplina disciplina){
        repository.save(disciplina);
    }
    public void atualizar(Long id, Disciplina disciplina) {
        var caixa = repository.findById(id);
        if(!caixa.isEmpty()){
            repository.save(disciplina);
        }
    }
    public void deletarPorId(Long id){
        var caixa = repository.findById(id);
        if(!caixa.isEmpty()){
            repository.deleteById(id);
        }
    }
    //stream() => trabalha com lista
    //repository
    //ModelMapper => converte um objeto em outro; trabalha com lista de objetos
}
