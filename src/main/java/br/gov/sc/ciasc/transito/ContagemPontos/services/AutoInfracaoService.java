package br.gov.sc.ciasc.transito.ContagemPontos.services;

import br.gov.sc.ciasc.transito.ContagemPontos.domain.AutoInfracao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoInfracaoService {


    public int somarPontos(List<AutoInfracao>infracaoList) {
        int pontuacao = 0;

        for (AutoInfracao autoInfracao : infracaoList) {
            pontuacao += autoInfracao.getNumeroDePontos();


        }

        return pontuacao;


    }
    public int somarPontosAnual(List<AutoInfracao> infracaoList){
        return 0;
    }


}

