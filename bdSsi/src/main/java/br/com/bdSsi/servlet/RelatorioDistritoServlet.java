package br.com.bdSsi.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bdSsi.dao.RelatorioDAO;
import br.com.bdSsi.factory.RelatorioFactory;
import br.com.bdSsi.util.RelatorioUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@WebServlet("/relatorioDistrito")
public class RelatorioDistritoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String TITLE = "RELATÓRIO GERAL DE DISTRITOS";
			String HEADER_1 = "ID DO DISTRITO";
			String HEADER_2 = "NOME";
			String HEADER_3 = "CARGO";
			String HEADER_4 = "Nº DE AGENTES";
			String HEADER_5 = "Nº DE BOS";
			String caminhoDoLogo = request.getRealPath("/images/itapipoca.png");

			JasperCompileManager.compileReportToFile(request.getRealPath("/jasper/RelatorioDistrito.jrxml"));

			String nome = request.getServletContext().getRealPath("/jasper/RelatorioDistrito.jasper");

			RelatorioDAO dao = new RelatorioDAO();
			RelatorioUtil relatorioUtil = new RelatorioUtil();

			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("TITLE", TITLE);
			parametros.put("HEADER_1", HEADER_1);
			parametros.put("HEADER_2", HEADER_2);
			parametros.put("HEADER_3", HEADER_3);
			parametros.put("HEADER_4", HEADER_4);
			parametros.put("HEADER_5", HEADER_5);
			parametros.put("LOGO", relatorioUtil.getInputStreamParametroLogo(caminhoDoLogo));

			JRDataSource dataSource = new JRBeanCollectionDataSource(dao.dataSourceRelatorioDistrito(), false);

			RelatorioFactory factory = new RelatorioFactory(nome, parametros, dataSource);

			factory.geraPDFParaOutputStream(response.getOutputStream());

		} catch (JRException ex) {
			Logger.getLogger(RelatorioDistritoServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(RelatorioDistritoServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
