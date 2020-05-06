package br.com.minhasacoes.modulos.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minhasacoes.modulos.entrypoint.response.AtivoResponse;
import br.com.minhasacoes.modulos.usecase.domain.Ativo;
import br.com.minhasacoes.modulos.usecase.impl.AtivoUsecaseImpl;


@RestController
@RequestMapping({"/ativo"})
public class AtivoController {

	@Autowired
	private AtivoUsecaseImpl ativoUsecase;
	
	@GetMapping("/{id}")
	public ResponseEntity<AtivoResponse> obterAtivoById(@PathVariable String id) {
		return ativoUsecase.obterAtivo(id)
				.map(registro -> ResponseEntity.ok().body(converterParaAtivoResponse(registro)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	private AtivoResponse converterParaAtivoResponse(Ativo ativo) {
		if (ativo != null) {
			AtivoResponse response = new AtivoResponse();
			response.setId(ativo.getId());
			response.setNome(ativo.getNome());
			response.setTipo(ativo.getTipo().getDescricao());
			response.setSetor(ativo.getSetor().getDescricao());
			response.setSituacao(ativo.getSituacao());
			return response;
		}
		return null; 
	}

}
