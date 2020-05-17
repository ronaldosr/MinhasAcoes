package br.com.minhasacoes.modulos.usecase.interfaces;

import java.util.Optional;

import br.com.minhasacoes.modulos.usecase.domain.Ativo;

public interface AtivoUsecase {

	public Optional<Ativo> obterAtivoPorId(Long id);
	
	public Optional<Ativo> cadastarAtivo(Ativo ativo);
	
	public Boolean temAtivoPorCodigo(String codigoAtivo);
	
	public Optional<Ativo> obterAtivoPorCodigo(String codigoAtivo);
}
