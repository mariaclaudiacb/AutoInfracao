package br.gov.sc.ciasc.transito.ContagemPontos.domain;
import java.time.LocalDate;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Data
public class AutoInfracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigoInfracao;
    private String placa;
    private String numeroAuto;
    private String pontos;
    private String situacao;
    private Long orgao;
    private LocalDate dataAutuacao;


    public int getNumeroDePontos() {
        if(getVerificarPadraoPontuacao()) {
            if(situacao.equals("Em recurso")){
                return 0;
            }
            String[] ponto = pontos.split("-");
            if (ponto[0].equals("3") || ponto[0].equals("4") || ponto[0].equals("5") || ponto[0].equals("7")) {
                return Integer.parseInt(ponto[0]);
            }
        }
            throw new IllegalArgumentException("Pontuação Inválida");
    }

    public boolean getVerificarPadraoPontuacao(){

        if(pontos.equals("3-Leve") ||pontos.equals("4-Média")|| pontos.equals("5-Grave")||pontos.equals("7-Gravíssima")){
            return true;
        }

        return false;
    }

    public boolean getVerificarSituacao(){
        if(situacao.equals("Ativo") || situacao.equals("Em recurso")){
            return true;
        }
        return false;
    }
}
