package br.com.minhasacoes.modulos.usecase.domain;

import br.com.minhasacoes.modulos.dataprovider.enums.Setor;
import br.com.minhasacoes.modulos.dataprovider.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ativo {

	private String id;
	private String nome;
	private Tipo tipo;
	private Setor setor;	
	private String situacao;
}
