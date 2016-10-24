package br.com.bdSsi.model;

public enum SituacaoEnum {
	culpado("Culpado"), vitima("Vítima");

	private String descricao;

	private SituacaoEnum(String descricao) {
		this.descricao = descricao;
	}
}
