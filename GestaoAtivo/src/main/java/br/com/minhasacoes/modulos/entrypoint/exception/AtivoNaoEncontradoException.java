package br.com.minhasacoes.modulos.entrypoint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AtivoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -3263699926888098838L;

	public AtivoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
