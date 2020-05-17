package br.com.minhasacoes.modulos.entrypoint.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtivoResponse implements Serializable {

	private static final long serialVersionUID = -274239868886531500L;

	private Long id;
	private String codigo;
	private String nome;
	private String tipo;
	private String setor;	
	private String situacao;	
}
