package br.com.etechoracio.pw3_study.repository;

import br.com.etechoracio.pw3_study.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DisciplinaRepository extends JpaRepository<Disciplina,Long> {

}
