package br.com.minhasacoes.modulos.entrypoint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AtivoJaCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 6197925117681216473L;

	public AtivoJaCadastradoException(String mensagem) {
		super(mensagem);
	}	
}
