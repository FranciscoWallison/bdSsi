package br.com.bdSsi.model;

public class DistritoRelatorio {

	private Integer identificacaoDistrito;
	private String nome;
	private String cargo;
	private Integer quantidadeAgentes;
	private Integer quantidadeBO;

	public Integer getIdentificacaoDistrito() {
		return identificacaoDistrito;
	}

	public void setIdentificacaoDistrito(Integer identificacaoDistrito) {
		this.identificacaoDistrito = identificacaoDistrito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getQuantidadeAgentes() {
		return quantidadeAgentes;
	}

	public void setQuantidadeAgentes(Integer quantidadeAgentes) {
		this.quantidadeAgentes = quantidadeAgentes;
	}

	public Integer getQuantidadeBO() {
		return quantidadeBO;
	}

	public void setQuantidadeBO(Integer quantidadeBO) {
		this.quantidadeBO = quantidadeBO;
	}
	
}
