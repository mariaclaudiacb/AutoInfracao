package br.gov.sc.ciasc.transito.ContagemPontos.domain;

import br.gov.sc.ciasc.transito.ContagemPontos.services.AutoInfracaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AutoInfracaoTest {
    @Test
    public void NumeroDePontos() {
        // assertEquals("7", AutoInfracao.numeroDePontos(pontos));

        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-Gravíssima");
        assertEquals(7, ai.getNumeroDePontos());


    }

    @Test
    public void VerificarPadraoPontuacao() {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-Gravivissima");
        assertFalse(ai.getVerificarPadraoPontuacao());
    }

    @Test
    public void VerificarPadraoPontucao2() {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-Gravíssima");
        assertTrue(ai.getVerificarPadraoPontuacao());
    }

    @Test
    public void SomarPontos() {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("4-Média");

        AutoInfracao ai1 = new AutoInfracao();
        ai1.setPontos("5-Grave");

        List<AutoInfracao> infracaolist = new ArrayList<>();
        infracaolist.add(ai);
        infracaolist.add(ai1);

        AutoInfracaoService ais = new AutoInfracaoService();
        //int contagemPontos = ais.somarPontos(infracaolist);
        assertEquals(9, ais.somarPontos(infracaolist));
    }

    //@Ignore
    @Test
    public void SomarPontosAnual() {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("3-Leve");
        ai.setDataAutuacao(LocalDate.of(2018, 6, 24));

        AutoInfracao ai2 = new AutoInfracao();
        ai2.setPontos("4-Média");
        ai2.setDataAutuacao(LocalDate.of(2018, 12, 25));

        AutoInfracao ai3 = new AutoInfracao();
        ai3.setPontos("7-Gravíssima");
        ai3.setDataAutuacao(LocalDate.of(2019, 5, 30));

        AutoInfracao ai4 = new AutoInfracao();
        ai4.setPontos("5-Leve");
        ai4.setDataAutuacao(LocalDate.of(2019, 9, 1));

        List<AutoInfracao> infracaoList = new ArrayList<>();
        infracaoList.add(ai);
        infracaoList.add(ai2);
        infracaoList.add(ai3);
        infracaoList.add(ai4);

        AutoInfracaoService ais = new AutoInfracaoService();
        assertEquals(11, ais.somarPontosAnual(infracaoList, LocalDate.of(2018, 7, 1)));
    }

 @Test
        public void VerificaPontuacao() {

     List<AutoInfracao> infracaoList = new ArrayList<>();

     AutoInfracao ai1 = new AutoInfracao();
     ai1.setPontos("7-Gravíssima");
     ai1.setDataAutuacao(LocalDate.of(2019, 5, 9));

     AutoInfracao ai2 = new AutoInfracao();
     ai2.setPontos("7-Gravíssima");
     ai2.setDataAutuacao(LocalDate.of(2019, 6, 10));

     AutoInfracao ai3 = new AutoInfracao();
     ai3.setPontos("7-Gravíssima");
     ai3.setDataAutuacao(LocalDate.of(2019, 7, 11));
     infracaoList = Arrays.asList(ai1, ai2, ai3);

     AutoInfracaoService ais = new AutoInfracaoService();
     assertTrue(ais.carteiraSuspensa(infracaoList, LocalDate.of(2019, 5, 8)));

 }
 @Test
    public void VerificaInicioContagemPontos(){
     List<AutoInfracao> infracaoList = new ArrayList<>();
     AutoInfracao ai = new AutoInfracao();
     ai.setPontos("3-Leve");
     ai.setDataAutuacao(LocalDate.of(2014,4,2));

     AutoInfracao ai2 = new AutoInfracao();
     ai2.setPontos("4-Média");
     ai2.setDataAutuacao(LocalDate.of(2014, 10, 25));

     AutoInfracao ai3 = new AutoInfracao();
     ai3.setPontos("7-Gravíssima");
     ai3.setDataAutuacao(LocalDate.of(2019, 4, 3));

     AutoInfracao ai4 = new AutoInfracao();
     ai4.setPontos("5-Grave");
     ai4.setDataAutuacao(LocalDate.of(2019, 1,21));

     infracaoList = Arrays.asList(ai, ai2, ai3,ai4);
     AutoInfracaoService ais = new AutoInfracaoService();
     assertEquals(16, ais.inicioContagemPontos(infracaoList, LocalDate.of(2014,4,03)));
    }

}
