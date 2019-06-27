package br.gov.sc.ciasc.transito.ContagemPontos.services;

import br.gov.sc.ciasc.transito.ContagemPontos.domain.AutoInfracao;
//import jdk.vm.ci.meta.Local;
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

    public boolean VerificaCNHAnoAFrente(List<AutoInfracao> infracaoList, LocalDate dataEspecifica) {
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

    public boolean VerificaCNHAnoAtras(List<AutoInfracao> infracaoList, LocalDate dataEspecifica) {
        int pontuacao = 0;

        for (AutoInfracao autoInfracao : infracaoList) {
            if (autoInfracao.getDataAutuacao().isAfter(dataEspecifica) && autoInfracao.getDataAutuacao().isBefore(dataEspecifica.minusYears(1)))
                ;
            {
                pontuacao += autoInfracao.getNumeroDePontos();
            }
        }
        if (pontuacao >= 20) {
            return true;
        }

        return false;
    }

    public int PontuacaoTotalUltimos5Anos(List<AutoInfracao> infracaoList, LocalDate dataEspecifica) {
        int pontuacao = 0;
        for (AutoInfracao autoInfracao : infracaoList) {
            if (autoInfracao.getDataAutuacao().isAfter(dataEspecifica)) {
                pontuacao += autoInfracao.getNumeroDePontos();
            }
        }
        return pontuacao;
    }

    public int verifcaPontuacao5Anos(List<AutoInfracao> infracaoList, LocalDate dataEspecifica) {
        int pontuacao = 0;
        int i;
        int j;

        for (i = 0; i < infracaoList.size(); i++) {
            AutoInfracao autoInfracao = infracaoList.get(i);
            if (autoInfracao.getDataAutuacao().isBefore(dataEspecifica) && autoInfracao.getDataAutuacao().isAfter(dataEspecifica.minusYears(5))) {

                pontuacao = autoInfracao.getNumeroDePontos();

                for (j = i + 1; j < infracaoList.size(); j++) {
                    AutoInfracao autoInfracao2 = infracaoList.get(j);
                    if (autoInfracao2.getDataAutuacao().isAfter(autoInfracao.getDataAutuacao()) && autoInfracao2.getDataAutuacao().isBefore(autoInfracao.getDataAutuacao().plusYears(1)))
                        pontuacao += autoInfracao2.getNumeroDePontos();
                    if (pontuacao >= 20) {
                        return pontuacao;
                    }
                }
            }
        }

        return -1;
    }

}


















