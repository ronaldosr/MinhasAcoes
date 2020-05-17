package br.com.minhasacoes.modulos.entrypoint.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class AtivoRequest implements Serializable {

	private static final long serialVersionUID = -8276283577689765229L;
	
	@NotNull(message = "Por favo, informe o código.")
	@Size(min = 5, max = 5, message = "Por favor, informe um código válido.")
	private String codigo;
	
	@NotNull(message = "Por favor, informe o nome.")
	@Size(min = 3, max = 50, message = "Por favor, informe um nome válido.")
	private String nome;
	
	@NotNull(message = "Por favor, informe o tipo.")
	@Min(value = 1, message = "Por favor, informe um tipo válido.")
	@Max(value = 2, message = "Por favor, informe um tipo válido.")
	private int tipo;
	
	@NotNull(message = "Por favor, informe o setor.")
	@Min(value = 1, message = "Por favor, informe um setor válido.")
	@Max(value = 10, message = "Por favor, informe um setor válido.")
	private int setor;		
}
