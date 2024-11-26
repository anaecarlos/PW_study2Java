package br.com.etechoracio.pw3_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_CONEXAO")
public class Conexao {
    @Id
    @Column(name = "ID_CONEXAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DT_CRIACAO")
    private LocalDateTime dtCriacao;
    @ManyToOne
    @JoinColumn(name = "ID_MONITOR")
    private Monitor monitor;
}
