package br.com.bdSsi.model;

public enum SituacaoEnum {
	A("culpado"), B("vitima");

	private String descricao;

	private SituacaoEnum(String descricao) {
		this.descricao = descricao;
	}
}
