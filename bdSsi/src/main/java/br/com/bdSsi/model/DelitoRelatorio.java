package br.com.bdSsi.model;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class DelitoRelatorio {

	private String rg;
	private String nome;
	private Calendar dataNascimento;
	private String estadoCivil;
	private String escolaridade;
	private String descricaoDelito;
	private Calendar dataDelito;
	private Time horaDelito;
	private SituacaoEnum situacao;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento.getTime();
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getDescricaoDelito() {
		return descricaoDelito;
	}

	public void setDescricaoDelito(String descricaoDelito) {
		this.descricaoDelito = descricaoDelito;
	}

	public Date getDataDelito() {
		return dataDelito.getTime();
	}

	public void setDataDelito(Calendar dataDelito) {
		this.dataDelito = dataDelito;
	}

	public Time getHoraDelito() {
		return horaDelito;
	}

	public void setHoraDelito(Time horaDelito) {
		this.horaDelito = horaDelito;
	}

	public String getSituacao() {
		return situacao.toString();
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}

}
