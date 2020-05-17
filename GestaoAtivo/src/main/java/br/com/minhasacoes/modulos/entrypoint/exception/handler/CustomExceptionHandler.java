package br.com.minhasacoes.modulos.entrypoint.exception.handler;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.minhasacoes.modulos.entrypoint.exception.AtivoCustomException;
import br.com.minhasacoes.modulos.entrypoint.exception.AtivoJaCadastradoException;
import br.com.minhasacoes.modulos.entrypoint.exception.AtivoNaoEncontradoException;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler  {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, 
			HttpStatus status, WebRequest request) {
		List<String> listaErros = new ArrayList<String>();
		
		for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
			listaErros.add(erro.getField() + ": " + erro.getDefaultMessage());
		}
		
		for (ObjectError erro : ex.getBindingResult().getGlobalErrors()) {
			listaErros.add(erro.getObjectName() + ": " + erro.getDefaultMessage());
		}
		
		AtivoCustomException customException = new AtivoCustomException(new Date(), HttpStatus.BAD_REQUEST, listaErros);
		return handleExceptionInternal(ex, customException, headers, customException.getHttpStatus(), request);
	}
	
	@ExceptionHandler(AtivoNaoEncontradoException.class)
	public final ResponseEntity<AtivoCustomException> ativoNaoEncontradoException(AtivoNaoEncontradoException ex, WebRequest request) {
		List<String> descricaoErros = new ArrayList<String>();
		descricaoErros.add(ex.getMessage());
		
		AtivoCustomException customException = new AtivoCustomException(new Date(), HttpStatus.NOT_FOUND, descricaoErros);
		return new ResponseEntity<AtivoCustomException>(customException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AtivoJaCadastradoException.class)
	public final ResponseEntity<AtivoCustomException> ativoJaCadastradoException(AtivoJaCadastradoException ex, WebRequest request) {
		List<String> descricaoErros = new ArrayList<String>();
		descricaoErros.add(ex.getMessage());
		
		AtivoCustomException customException = new AtivoCustomException(new Date(), HttpStatus.NOT_FOUND, descricaoErros);
		return new ResponseEntity<AtivoCustomException>(customException, HttpStatus.NOT_FOUND);
	}	
}
