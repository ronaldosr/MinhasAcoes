package br.com.minhasacoes.modulos.dataprovider.enums;

import java.util.HashMap;
import java.util.Map;

public enum Setor {

	BENS_INDUSTRIAIS(1, "Bens industriais"),
	COMUNICACOES(2, "Comunicações"),
	CONSUMO_CICLICO(3, "Consumo cíclico"),
	CONSUMO_NAO_CICLICO(4, "Consumo não-cíclico"),
	FINANCEIRO(5, "Financeiro"),
	MATERIAIS_BASICOS(6, "Materiais básicos"),
	PETROLEO_GAS_BIOCOMBUSTIVEL(7, "Petróleo, Gás e Biocombustível"),
	SAUDE(8, "Saúde"),
	TECNOLOGIA_INFORMACAO(9, "Tecnologia da informação"),
	UTILIDADE_PUBLICA(10, "Utilidade pública");
		
	private int id;
	private String descricao;
	
	private static Map<Integer, Setor> setor;

	
	private Setor(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Setor getSetorPorId(int id) {
		return setor.get(id);
	}
	
	static {
		setor = new HashMap<Integer, Setor>();
		for (Setor s : values()) setor.put(s.getId(), s);
	}
}
