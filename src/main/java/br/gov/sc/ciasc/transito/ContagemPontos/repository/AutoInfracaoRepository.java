package br.gov.sc.ciasc.transito.ContagemPontos.repository;

import br.gov.sc.ciasc.transito.ContagemPontos.domain.AutoInfracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoInfracaoRepository extends JpaRepository<AutoInfracao,Integer> {
}
