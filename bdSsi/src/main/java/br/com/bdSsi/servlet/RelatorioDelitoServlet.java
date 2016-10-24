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

@WebServlet("/relatorioDelito")
public class RelatorioDelitoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String TITLE = "RELATÓRIO DE DELITOS INTERNOS";
			String HEADER_1 = "RG";
			String HEADER_2 = "NOME";
			String HEADER_3 = "DATA NASC.";
			String HEADER_4 = "ESTADO CIVIL";
			String HEADER_5 = "ESCOLARIDADE";
			String HEADER_6 = "DESC. DELITO";
			String HEADER_7 = "DATA DELITO";
			String HEADER_8 = "HR DELITO";
			String HEADER_9 = "SITUACAO";
			String caminhoDoLogo = request.getRealPath("/images/itapipoca.png");

			JasperCompileManager.compileReportToFile(request.getRealPath("/jasper/RelatorioDelito.jrxml"));

			String nome = request.getServletContext().getRealPath("/jasper/RelatorioDelito.jasper");

			RelatorioDAO dao = new RelatorioDAO();
			RelatorioUtil relatorioUtil = new RelatorioUtil();

			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("TITLE", TITLE);
			parametros.put("HEADER_1", HEADER_1);
			parametros.put("HEADER_2", HEADER_2);
			parametros.put("HEADER_3", HEADER_3);
			parametros.put("HEADER_4", HEADER_4);
			parametros.put("HEADER_5", HEADER_5);
			parametros.put("HEADER_6", HEADER_6);
			parametros.put("HEADER_7", HEADER_7);
			parametros.put("HEADER_8", HEADER_8);
			parametros.put("HEADER_9", HEADER_9);
			parametros.put("LOGO", relatorioUtil.getInputStreamParametroLogo(caminhoDoLogo));

			JRDataSource dataSource = new JRBeanCollectionDataSource(dao.dataSourceRelatorioDelito(), false);

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
