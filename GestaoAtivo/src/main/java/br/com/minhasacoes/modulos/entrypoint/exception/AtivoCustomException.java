package br.com.minhasacoes.modulos.entrypoint.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class AtivoCustomException {

	private Date timestamp;
	private HttpStatus httpStatus;
	private List<String> mensagens;
	
	public AtivoCustomException(Date timestamp, HttpStatus httpStatus, List<String> mensagens) {
		super();
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
		this.mensagens = mensagens;
	}

	public AtivoCustomException(Date timestamp, HttpStatus httpStatus, String mensagem) {
		super();
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
		mensagens = Arrays.asList(mensagem);
	}
	
}
