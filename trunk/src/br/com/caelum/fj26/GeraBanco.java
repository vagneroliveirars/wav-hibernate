package br.com.caelum.fj26;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Classe que gera as tabelas no bd
 * 
 * @author vagner
 * 
 */
public class GeraBanco {
	public static void main(String[] args) {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure();
		SchemaExport se = new SchemaExport(configuration);
		se.create(true, true);
	}

}
