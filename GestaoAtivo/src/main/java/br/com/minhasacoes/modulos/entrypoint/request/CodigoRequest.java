package br.com.minhasacoes.modulos.entrypoint.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class CodigoRequest implements Serializable {

	private static final long serialVersionUID = 1225313956869639575L;
	
	@NotBlank(message = "Por favo, informe o código.")
	@Size(min = 5, max = 5, message = "Por favor, informe um código válido.")
	private String codigo;
}
