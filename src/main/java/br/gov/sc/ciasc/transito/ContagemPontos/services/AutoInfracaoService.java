package br.gov.sc.ciasc.transito.ContagemPontos.services;

import br.gov.sc.ciasc.transito.ContagemPontos.domain.AutoInfracao;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutoInfracaoService {


    public int somarPontos(List<AutoInfracao> infracaoList) {
        int pontuacao = 0;

        for (AutoInfracao autoInfracao : infracaoList) {
            pontuacao += autoInfracao.getNumeroDePontos();


        }

        return pontuacao;


    }

    public int somarPontosAnual(List<AutoInfracao> infracaoList, LocalDate dataEspecifica) {
        //AutoInfracao autoInfracao =new AutoInfracao();
        int pontuacao = 0;

        for (AutoInfracao autoInfracao : infracaoList) {
            if (autoInfracao.getDataAutuacao().isAfter(dataEspecifica) && autoInfracao.getDataAutuacao().isBefore(dataEspecifica.plusYears(1))) {
                pontuacao += autoInfracao.getNumeroDePontos();
            }
        }
        return pontuacao;

    }

    public boolean carteiraSuspensa(List<AutoInfracao> infracaoList, LocalDate dataEspecifica) {
        int pontuacao = 0;

        for (AutoInfracao autoInfracao : infracaoList) {
            if (autoInfracao.getDataAutuacao().isAfter(dataEspecifica) && autoInfracao.getDataAutuacao().isBefore(dataEspecifica.plusYears(1))) {
                pontuacao += autoInfracao.getNumeroDePontos();
            }
        }
        if (pontuacao >= 20) {
            return true;
        }

        return false;
    }


    public int inicioContagemPontos (List<AutoInfracao> infracaoList, LocalDate dataEspecifica) {
        int pontuacao = 0;
        for (AutoInfracao autoInfracao : infracaoList) {
           if(autoInfracao.getDataAutuacao().isAfter(dataEspecifica)){
                pontuacao += autoInfracao.getNumeroDePontos();
           }
        }
        return pontuacao;
    }





}




















