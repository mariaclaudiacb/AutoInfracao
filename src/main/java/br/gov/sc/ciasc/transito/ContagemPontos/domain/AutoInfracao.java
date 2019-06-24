package br.gov.sc.ciasc.transito.ContagemPontos.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class AutoInfracao {
    private String placa;
    private String numeroAuto;
    private String codigoInfracao;
    private String pontos;
    private String situacao;
    private Long orgao;
    //LocalDate dataAutuacao;


    public String getNumeroDePontos() {
        String[] ponto = pontos.split("-");
        if(ponto[0].equals("4")||ponto[0].equals("5")||ponto[0].equals("7")) {
            return ponto[0];
        }
        String erro = "Pontuação inválida";
        return erro;
    }

    public boolean getVerificarPadraoPontuacao(){
        String[] ponto = new String[pontos.length()];
        if(ponto[0].equals("4")|| ponto[0].equals("5") || ponto[0].equals("7")) {
            return true;
        }
        if(ponto[1].equals("-")){
            return true;
        }
        if(pontos.equals("4-Média")|| pontos.equals("5-Grave")||pontos.equals("7-Gravíssima")){
            return true;
        }

        return false;
    }
}
