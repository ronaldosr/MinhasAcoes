package br.com.minhasacoes.modulos.usecase.interfaces;

import java.util.Optional;

import br.com.minhasacoes.modulos.usecase.domain.Ativo;

public interface AtivoUsecase {

	public Optional<Ativo> obterAtivo(String id);
}
