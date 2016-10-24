package br.com.bdSsi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RelatorioUtil {
	public InputStream getInputStreamParametroLogo(String caminhoDoLogo) {
		InputStream inputStreamDoLogo = null;
		try {
			File file = new File(caminhoDoLogo);
			if (file.exists()) {
				inputStreamDoLogo = new FileInputStream(file);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return inputStreamDoLogo;
	}
}
