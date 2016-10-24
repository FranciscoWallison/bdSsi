package br.com.bdSsi.factory;

import java.io.OutputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class RelatorioFactory {

	private String nomeArquivo;
	private Map<String, Object> parametros;
	private JRDataSource dataSource;

	public RelatorioFactory(String nomeArquivo, Map<String, Object> parametros, JRDataSource dataSource) {
		this.nomeArquivo = nomeArquivo;
		this.parametros = parametros;
		this.dataSource = dataSource;
	}

	public void geraPDFParaOutputStream(OutputStream outputStream) {
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(nomeArquivo, parametros, dataSource);

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
			exporter.exportReport();

		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}
}
