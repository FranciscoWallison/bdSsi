package br.com.bdSsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.bdSsi.factory.ConnectionFactory;
import br.com.bdSsi.model.DelitoRelatorio;
import br.com.bdSsi.model.DistritoRelatorio;
import br.com.bdSsi.model.SituacaoEnum;

public class RelatorioDAO {
	private Connection conexao;

	public RelatorioDAO() throws ClassNotFoundException {
		this.conexao = new ConnectionFactory().getConnection();
	}

	public List<DistritoRelatorio> dataSourceRelatorioDistrito() throws SQLException {

		try {
			PreparedStatement stmt = this.conexao.prepareStatement("select num_distrito as identificacaoDestrito,"
					+ " funcionario.nome as nome, cargo.nome_cargo as cargo,"
					+ " (select count(funcionario.cargo_id) from funcionario where funcionario.cargo_id = 3"
					+ " and delegacia.num_distrito = funcionario.lotacao) as quantidadeAgentesNoDistrito,"
					+ " (select count(ocorrencia.boletim_de_ocorrencia_id) from ocorrencia"
					+ " where ocorrencia.delegacia_num_distrito = delegacia.num_distrito) as quantidadeBoLavrados"
					+ " from delegacia" + " inner join funcionario on delegacia.num_distrito = funcionario.lotacao"
					+ " inner join cargo on funcionario.cargo_id = cargo.id_cargo"
					+ " where funcionario.cargo_id = 1 or funcionario.cargo_id = 2"
					+ " order by delegacia.num_distrito;");

			ResultSet rs = stmt.executeQuery();
			List<DistritoRelatorio> listaDataSource = new ArrayList<DistritoRelatorio>();
			DistritoRelatorio distritoRelatorio = null;

			while (rs.next()) {
				Integer identificacaoDestrito = rs.getInt("identificacaoDestrito");
				String nome = rs.getString("nome");
				String cargo = rs.getString("cargo");
				Integer quantidadeAgentes = rs.getInt("quantidadeAgentesNoDistrito");
				Integer quantidadeBO = rs.getInt("quantidadeBoLavrados");

				distritoRelatorio = new DistritoRelatorio();
				distritoRelatorio.setIdentificacaoDistrito(identificacaoDestrito);
				distritoRelatorio.setNome(nome);
				distritoRelatorio.setCargo(cargo);
				distritoRelatorio.setQuantidadeAgentes(quantidadeAgentes);
				distritoRelatorio.setQuantidadeBO(quantidadeBO);

				listaDataSource.add(distritoRelatorio);
			}

			return listaDataSource;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<DelitoRelatorio> dataSourceRelatorioDelito() throws SQLException {

		try {
			PreparedStatement stmt = this.conexao.prepareStatement(
					"select presidiario.rg as rg, presidiario.nome as nome, presidiario.data_nascimento as dataNascimento, "
							+ " presidiario.estado_civil as estadoCivil, presidiario.escolaridade as escolaridade,"
							+ " delito_no_presidio.desc_delito as descricaoDelito, delito_no_presidio.data_delito as dataDelito,"
							+ " delito_no_presidio.hora_delito as horaDelito, delito_no_presidio.situacao as situacaoNoDelito"
							+ " from presidiario" + " inner join registro_de_delito_interno on"
							+ " presidiario.id_presidiario = registro_de_delito_interno.delito_presidiario_id"
							+ " inner join delito_no_presidio on"
							+ " registro_de_delito_interno.delito_presidiario_id = delito_no_presidio.id_delito_pres ");

			ResultSet rs = stmt.executeQuery();
			List<DelitoRelatorio> listaDataSource = new ArrayList<DelitoRelatorio>();
			DelitoRelatorio delitoRelatorio = null;

			while (rs.next()) {
				String rg = rs.getString("rg");
				String nome = rs.getString("nome");

				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));

				String estadoCivil = rs.getString("estadoCivil");
				String escolaridade = rs.getString("escolaridade");
				String descricaoDelito = rs.getString("descricaoDelito");

				Calendar dataDelito = Calendar.getInstance();
				dataDelito.setTime(rs.getDate("dataDelito"));

				Time horaDelito = rs.getTime("horaDelito");
				SituacaoEnum situacao = SituacaoEnum.valueOf(rs.getString("situacaoNoDelito"));

				delitoRelatorio = new DelitoRelatorio();
				delitoRelatorio.setRg(rg);
				delitoRelatorio.setDataNascimento(dataNascimento);
				delitoRelatorio.setEstadoCivil(estadoCivil);
				delitoRelatorio.setEscolaridade(escolaridade);
				delitoRelatorio.setDescricaoDelito(descricaoDelito);
				delitoRelatorio.setDataDelito(dataDelito);
				delitoRelatorio.setHoraDelito(horaDelito);
				delitoRelatorio.setSituacao(situacao);

				listaDataSource.add(delitoRelatorio);
			}

			return listaDataSource;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
