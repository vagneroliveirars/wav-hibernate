package br.com.caelum.fj26;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Classe que retorna sessões
 * 
 * @author vagner
 * 
 */
public class HibernateUtil {

	private static Logger logger = Logger.getLogger(HibernateUtil.class.getName());
	private static SessionFactory factory;

	static {
		Configuration cfg = new Configuration();
		cfg.configure();

		factory = cfg.buildSessionFactory();
	}

	public static Session openSession() {
		logger.info("opening new session");
		return factory.openSession();
	}

}
