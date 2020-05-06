package br.com.minhasacoes.modulos.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minhasacoes.modulos.dataprovider.entity.CotacaoData;
import br.com.minhasacoes.modulos.dataprovider.entity.CotacaoDataPk;

@Repository
public interface CotacaoRepository extends JpaRepository<CotacaoData, CotacaoDataPk> {

}
