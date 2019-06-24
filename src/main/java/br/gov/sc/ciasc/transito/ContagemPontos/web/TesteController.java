package br.gov.sc.ciasc.transito.ContagemPontos.web;

import br.gov.sc.ciasc.transito.ContagemPontos.domain.AutoInfracao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {
    @GetMapping(value = "/pontos/{texto}")
    public String mostrarNumeroPontos(@PathVariable String texto) {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos(texto);
        return ai.getNumeroDePontos();
    }
}
