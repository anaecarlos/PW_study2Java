//3AI - Leonardo Sirpa e Caio dos Santos
package br.com.etechoracio.pw3_study.DTO;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MonitorDTO{
    private String nome;
    private String foto;
    private String whatsapp;
    private String email;
    private String conteudo;
    private Long idDisciplina;
}
