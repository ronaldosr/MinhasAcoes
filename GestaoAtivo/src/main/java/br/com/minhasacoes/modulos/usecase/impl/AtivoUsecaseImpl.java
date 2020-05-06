package br.com.minhasacoes.modulos.usecase.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minhasacoes.modulos.dataprovider.entity.AtivoData;
import br.com.minhasacoes.modulos.dataprovider.enums.Setor;
import br.com.minhasacoes.modulos.dataprovider.enums.Tipo;
import br.com.minhasacoes.modulos.dataprovider.repository.AtivoRepository;
import br.com.minhasacoes.modulos.usecase.domain.Ativo;
import br.com.minhasacoes.modulos.usecase.interfaces.AtivoUsecase;

@Service
public class AtivoUsecaseImpl implements AtivoUsecase {

	@Autowired
	private AtivoRepository ativoRepository; 
	
	@Override
	public Optional<Ativo> obterAtivo(String id) {
		return converterParaAtivo(ativoRepository.findById(id));
	}
	
	/**
	 * @apiNote Converte o classe AtivoData na classe de domínio Ativo
	 * @param ativoData
	 * @return ativo
	 */
	private Optional<Ativo> converterParaAtivo (Optional<AtivoData> ativoData) {				
		if (ativoData.isPresent()) {			
			Optional<Ativo> ativo = Optional.empty();
			ativo.get().setId(ativoData.get().getId());
			ativo.get().setNome(ativoData.get().getNome());
			ativo.get().setTipo(Tipo.getTipoPorId(ativoData.get().getTipo()));
			ativo.get().setSetor(Setor.getSetorPorId(ativoData.get().getSetor()));
			if (ativoData.get().isEstaHabilitado()) {
				ativo.get().setSituacao("Habilitado");
			} else {
				ativo.get().setSituacao("Desabilitado");
			}
			return ativo;
		}		
		return null;				
	}
}
