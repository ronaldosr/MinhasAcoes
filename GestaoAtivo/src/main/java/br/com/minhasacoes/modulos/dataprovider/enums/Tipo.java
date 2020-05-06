package br.com.minhasacoes.modulos.dataprovider.enums;

import java.util.HashMap;
import java.util.Map;

public enum Tipo {

	ORDINARIA(1, "Ordinária"),
	PREFERENCIAL(2, "Preferencial");
	
	private int id;
	private String descricao;
	
	private static Map<Integer, Tipo> tipo;
	
	private Tipo(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Tipo getTipoPorId(int id) {
		return tipo.get(id);
	}
	
	static {
		tipo = new HashMap<Integer, Tipo>();
		for (Tipo t : values()) tipo.put(t.getId(), t);
	}

}
