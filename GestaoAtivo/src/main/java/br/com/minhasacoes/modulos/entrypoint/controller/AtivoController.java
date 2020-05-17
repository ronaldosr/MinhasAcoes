package br.com.minhasacoes.modulos.entrypoint.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.minhasacoes.modulos.dataprovider.enums.Setor;
import br.com.minhasacoes.modulos.dataprovider.enums.Tipo;
import br.com.minhasacoes.modulos.entrypoint.exception.AtivoJaCadastradoException;
import br.com.minhasacoes.modulos.entrypoint.exception.AtivoNaoEncontradoException;
import br.com.minhasacoes.modulos.entrypoint.request.AtivoRequest;
import br.com.minhasacoes.modulos.entrypoint.request.CodigoRequest;
import br.com.minhasacoes.modulos.entrypoint.response.AtivoResponse;
import br.com.minhasacoes.modulos.usecase.domain.Ativo;
import br.com.minhasacoes.modulos.usecase.impl.AtivoUsecaseImpl;


@RestController
@RequestMapping({"/ativos"})
public class AtivoController {

	@Autowired
	private AtivoUsecaseImpl ativoUsecase;
	
	@GetMapping("/{id}")
	public ResponseEntity<AtivoResponse> obterAtivoById(@PathVariable Long id) {
		if (id != null) {
			Optional<Ativo> ativo = ativoUsecase.obterAtivoPorId(id);
			if (ativo.isPresent()) {
				return new ResponseEntity<AtivoResponse>(converterParaAtivoResponse(ativo), HttpStatus.OK);			
			} else {
				throw new AtivoNaoEncontradoException("Não há ativos para o Id " + id + ".") ;
			}		
		} 
		return null;
	}
	
	@GetMapping()
	public ResponseEntity<AtivoResponse> obterAtivoByCodigo(@RequestBody CodigoRequest codigoRequest) {
		if (codigoRequest != null) {
			Optional<Ativo> ativo = ativoUsecase.obterAtivoPorCodigo(codigoRequest.getCodigo());
			if (ativo.isPresent()) {
				return new ResponseEntity<AtivoResponse>(converterParaAtivoResponse(ativo), HttpStatus.OK);
			} else {
				throw new AtivoNaoEncontradoException("Não há ativos para o Código " + codigoRequest.getCodigo() + "."); 
			}
		} 
		return null;
	}
	
	
	@PostMapping
	public ResponseEntity<AtivoResponse> cadastrarAtivo(@RequestBody @Valid AtivoRequest ativoRequest){
		if (ativoRequest != null) {
			if (!ativoUsecase.temAtivoPorCodigo(ativoRequest.getCodigo())) {
				Optional<Ativo> ativo = ativoUsecase.cadastarAtivo(converterParaAtivo(ativoRequest));
				if (ativo.isPresent()) {
					return new ResponseEntity<AtivoResponse>(converterParaAtivoResponse(ativo), HttpStatus.CREATED);
				} else {
					throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao cadastrar ativo.");
				}
			} else { 
				throw new AtivoJaCadastradoException("O ativo " + ativoRequest.getCodigo() + " encontra-se no cadastro."); 
			}
		}
		return null;
	}
	
	
	private Ativo converterParaAtivo(AtivoRequest ativoRequest) {
		if (ativoRequest != null) {
			Ativo ativo = new Ativo();
			ativo.setCodigo(ativoRequest.getCodigo());
			ativo.setNome(ativoRequest.getNome());
			ativo.setSetor(Setor.getSetorPorId(ativoRequest.getSetor()));
			ativo.setTipo(Tipo.getTipoPorId(ativoRequest.getTipo()));
			return ativo;
		}
		return null;
	}

	private AtivoResponse converterParaAtivoResponse(Optional<Ativo> ativo) {
		if (ativo.isPresent()) {			
			AtivoResponse response = new AtivoResponse();
			response.setId(ativo.get().getId());
			response.setCodigo(ativo.get().getCodigo());
			response.setNome(ativo.get().getNome());
			response.setTipo(ativo.get().getTipo().getDescricao());
			response.setSetor(ativo.get().getSetor().getDescricao());
			if (ativo.get().getSituacao()) {
				response.setSituacao("Habilitado");
			} else {
				response.setSituacao("Desabilitado");
			}
			return response;
		}
		return null; 
	}

}
