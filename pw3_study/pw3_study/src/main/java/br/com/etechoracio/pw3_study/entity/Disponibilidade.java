package br.com.etechoracio.pw3_study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_DISPONIBILIDADE")
public class Disponibilidade {
    @Id
    @Column(name = "ID_DISPONIBILIDADE")
    private Long id;
    @Column(name = "TX_DIA_SEMANA")
    private String diaSemana;
    @Column(name = "DT_DAS")
    private LocalDateTime dtDas;
    @Column(name = "DT_ATE")
    private LocalDateTime dtAte;
}
