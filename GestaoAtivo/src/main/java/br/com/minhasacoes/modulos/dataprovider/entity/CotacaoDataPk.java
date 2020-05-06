package br.com.minhasacoes.modulos.dataprovider.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CotacaoDataPk implements Serializable {

	private static final long serialVersionUID = -8869253142362335926L;
	
	@DateTimeFormat
	private Date id;
	
	private String idAtivo;
}
