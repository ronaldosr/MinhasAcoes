package br.com.minhasacoes.modulos.entrypoint.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtivoRequest implements Serializable {

	private static final long serialVersionUID = -8276283577689765229L;
	
	@NotEmpty(message = "Por favor, informe o id.")
	@Size(min = 5, max = 6, message = "Por favor, informe um id válido.")
	private String id;
	
	@NotEmpty(message = "Por favor, informe o nome.")
	@Size(min = 3, max = 50, message = "Por favor, informe um nome válido.")
	private String nome;
	
	@NotEmpty(message = "Por favor, informe o tipo.")
	@Size(min = 2, max = 2, message = "Por favor, informe um tipo válido." )
	private String tipo;
	
	@NotEmpty(message = "Por favor, informe o setor")
	@Size(min = 2, max = 2, message = "Por favor, informe um setor válido.")
	private String setor;	
	
	@NotEmpty(message = "Por favor, informe se o ativo deve ser habilitado.")
	private boolean estaHabilitado;	
}
