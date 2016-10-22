package br.com.bdSsi.dao;

import java.sql.Connection;

import br.com.bdSsi.factory.ConnectionFactory;

public class RelatorioDAO {
	private Connection conexao;

	public RelatorioDAO() throws ClassNotFoundException {
		this.conexao = new ConnectionFactory().getConnection();
	}
	/*
	 * public List<> getDataSourceRota(Integer tecnicoId) throws SQLException {
	 * try { PreparedStatement stmt = this.conexao.
	 * prepareStatement("SELECT distinct rota.data, funcionario.nome, " +
	 * "tecnico.idSky, rota.id " + "FROM tbos os " +
	 * "inner join tbrotalog rota on os.rota_id = rota.id " +
	 * "inner join tbtecnico tecnico on os.tecnico_id = tecnico.id " +
	 * "inner join tbfuncionario funcionario on tecnico.funcionario_id = funcionario.id "
	 * + "where tecnico.idSky = ?;"); stmt.setInt(1, tecnicoId);
	 * 
	 * List<ItensOrdemServicoRelatorio> listaItensOsRelatorio = new
	 * ArrayList<ItensOrdemServicoRelatorio>(); ItensOrdemServicoRelatorio
	 * itensOsRelatorio = null; ItensOrdemServico itensOS = null; Rota rota =
	 * null; Tecnico tecnico = null; Funcionario funcionario = null;
	 * 
	 * ResultSet rs = stmt.executeQuery(); while (rs.next()) { Calendar rotaData
	 * = Calendar.getInstance(); rotaData.setTime(rs.getDate("data"));
	 * 
	 * Integer rotaId = rs.getInt("id");
	 * 
	 * String tecnicoNome = rs.getString("nome"); String tecnicoCodigo =
	 * rs.getString("idSky");
	 * 
	 * rota = new Rota(); rota.setData(rotaData); rota.setId(rotaId);
	 * 
	 * funcionario = new Funcionario(); funcionario.setNome(tecnicoNome);
	 * 
	 * tecnico = new Tecnico(); tecnico.setIdSky(tecnicoCodigo);
	 * tecnico.setFuncionario(funcionario);
	 * 
	 * itensOS = new ItensOrdemServico(); itensOS.setRota(rota);
	 * itensOS.setTecnico(tecnico);
	 * 
	 * itensOsRelatorio = new ItensOrdemServicoRelatorio(itensOS);
	 * 
	 * listaItensOsRelatorio.add(itensOsRelatorio); } rs.close(); stmt.close();
	 * return listaItensOsRelatorio; } catch (SQLException e) { throw new
	 * RuntimeException(e); } }
	 */
}
