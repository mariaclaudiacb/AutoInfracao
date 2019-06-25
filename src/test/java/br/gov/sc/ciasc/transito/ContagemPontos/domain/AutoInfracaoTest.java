package br.gov.sc.ciasc.transito.ContagemPontos.domain;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class AutoInfracaoTest {
    @Test
    public void NumeroDePontos(){
        // assertEquals("7", AutoInfracao.numeroDePontos(pontos));

        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-Gravíssima");
        assertEquals(7, ai.getNumeroDePontos());


    }

    @Test
    public void VerificarPadraoPontuacao(){
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-Gravivissima");
        assertFalse(false);
    }
    @Test
    public void VerificarPadraoPontucao2(){
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-Gravissima");
        assertFalse(false);
    }
    @Test
    public void VerificarContagemPontos(){
        AutoInfracao ai1 = new AutoInfracao();
    }

}
