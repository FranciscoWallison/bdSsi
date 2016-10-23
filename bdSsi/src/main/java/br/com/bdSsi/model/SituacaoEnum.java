package br.com.bdSsi.model;

public enum SituacaoEnum {
	A("Culpado"), B("Vitima");

	private String descricao;

	private SituacaoEnum(String descricao) {
		this.descricao = descricao;
	}
}
