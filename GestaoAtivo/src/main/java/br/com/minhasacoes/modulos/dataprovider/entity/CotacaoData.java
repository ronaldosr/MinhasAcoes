package br.com.minhasacoes.modulos.dataprovider.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cotacao")
public class CotacaoData implements Serializable {

	private static final long serialVersionUID = -6000437520054777234L;

	@EmbeddedId
	@Column(name = "id")
	private CotacaoDataPk idCotacao;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	@Column(name = "variacao", nullable = false)
	private BigDecimal variacao;
	
	@Column(name = "minima", nullable = false)
	private BigDecimal minima;
	
	@Column(name = "maxima", nullable = false)
	private BigDecimal maxima;
	
	@Column(name = "volume", nullable = false)
	private BigDecimal volume;
	
}
