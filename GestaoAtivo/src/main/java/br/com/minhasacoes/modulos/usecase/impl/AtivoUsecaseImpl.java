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
	public Optional<Ativo> obterAtivoPorId(Long id) {
		if (id != null) {
			return converterParaAtivo(ativoRepository.findById(id));
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<Ativo> cadastarAtivo(Ativo ativo) {
		if (ativo != null) {			
			ativo.setSituacao(true);
			return converterParaAtivo(
					ativoRepository.save(converterParaAtivoData(ativo))
			);
		}
		return Optional.empty();
	}
	
	@Override
	public Optional<Ativo> obterAtivoPorCodigo(String codigo) {
		if (codigo != null) {
			return converterParaAtivo(ativoRepository.findByCodigo(codigo));
		} else {
			return Optional.empty();
		}
	}
	
	@Override
	public Boolean temAtivoPorCodigo(String codigoAtivo) {
		if (codigoAtivo != null) {
			Optional<Ativo> ativo = converterParaAtivo(ativoRepository.findByCodigo(codigoAtivo));
			if (ativo.isPresent()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	private AtivoData converterParaAtivoData(Ativo ativo) {
		if (ativo != null) {
			AtivoData ativoData = new AtivoData();
			ativoData.setCodigo(ativo.getCodigo());
			ativoData.setNome(ativo.getNome());
			ativoData.setSetor(ativo.getSetor().getId());
			ativoData.setTipo(ativo.getTipo().getId());
			ativoData.setEstaHabilitado(ativo.getSituacao());
			return ativoData;
		}
			
		return null;
	}

	private Optional<Ativo> converterParaAtivo (Optional<AtivoData> ativoData) {				
		if (ativoData.isPresent()) {
			Optional<Ativo> ativo = Optional.of(new Ativo());			
			ativo.get().setId(ativoData.get().getId());
			ativo.get().setCodigo(ativoData.get().getCodigo());
			ativo.get().setNome(ativoData.get().getNome());
			ativo.get().setTipo(Tipo.getTipoPorId(ativoData.get().getTipo()));
			ativo.get().setSetor(Setor.getSetorPorId(ativoData.get().getSetor()));
			ativo.get().setSituacao(ativoData.get().isEstaHabilitado());			
			return ativo;
		}		
		return Optional.empty();				
	}
	
	private Optional<Ativo> converterParaAtivo (AtivoData ativoData) {				
		if (ativoData != null) {
			Optional<Ativo> ativo = Optional.of(new Ativo());			
			ativo.get().setId(ativoData.getId());
			ativo.get().setCodigo(ativoData.getCodigo());
			ativo.get().setNome(ativoData.getNome());
			ativo.get().setTipo(Tipo.getTipoPorId(ativoData.getTipo()));
			ativo.get().setSetor(Setor.getSetorPorId(ativoData.getSetor()));
			ativo.get().setSituacao(ativoData.isEstaHabilitado());
			return ativo;
		}		
		return Optional.empty();				
	}

}
