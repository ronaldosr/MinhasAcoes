package br.com.minhasacoes.modulos.dataprovider.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ativo")
public class AtivoData implements Serializable {

	private static final long serialVersionUID = 8041778322744964986L;

	@Id
	@Column(name = "id", length = 5, nullable = false)
	private String id;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "tipo", length = 2, nullable = false)
	private int tipo;
	
	@Column(name = "setor", length = 2, nullable = false)
	private int setor;	
	
	@Column(name = "esta_habilitado", nullable = false)
	private boolean estaHabilitado;
}
