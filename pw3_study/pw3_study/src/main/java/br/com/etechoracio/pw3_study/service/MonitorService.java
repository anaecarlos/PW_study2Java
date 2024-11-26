package br.com.etechoracio.pw3_study.service;

import br.com.etechoracio.pw3_study.DTO.MonitorDTO;
import br.com.etechoracio.pw3_study.entity.Monitor;
import br.com.etechoracio.pw3_study.repository.MonitorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MonitorService{
    @Autowired
    private MonitorRepository repository;
    private ModelMapper modelMapper = new ModelMapper();
    public List<MonitorDTO> listar(){
        return repository.findAll()
                .stream()
                .map(e->modelMapper.map(e,MonitorDTO.class))
                .collect(Collectors.toList());
    }
    public Optional<MonitorDTO> buscar(Long id){
        return repository.findById(id).map(e->modelMapper.map(e,MonitorDTO.class));
    }
    public MonitorDTO cadastrar(MonitorDTO monitorDTO){
        Monitor monitor = modelMapper.map(monitorDTO,Monitor.class);
        repository.save(monitor);
        return monitorDTO;
    }
    public Optional<MonitorDTO> alterar(Long id, MonitorDTO monitorDTO){
        Monitor monitor = modelMapper.map(monitorDTO,Monitor.class);
        var caixa = repository.findById(id);
        if(caixa.isPresent()) {
            repository.save(monitor);
        }
        return caixa.map(e->modelMapper.map(e,MonitorDTO.class));
    }
    public Optional<MonitorDTO> excluir(Long id){
        var caixa = repository.findById(id);
        if(caixa.isPresent()){
            repository.deleteById(id);
        }
        return caixa.map(e->modelMapper.map(e,MonitorDTO.class));
    }
}
