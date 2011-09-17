package br.com.caelum.fj26;

import java.util.logging.Logger;

import org.hibernate.Session;

/**
 * Classe DAO generica que serve para qualquer entidade e que fornece as
 * operacoes mais basicas
 * 
 * @author vagner
 * 
 * @param <T>
 */
public class Dao<T> {

	private static Logger logger = Logger.getLogger(Dao.class.getName());
	private Class persistentClass;
	private Session session;

	public Dao(Session session, Class persistentClass) {
		this.session = session;
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T load(Long id) {
		logger.info("lendo " + persistentClass + " com id " + id);
		return (T) session.load(persistentClass, id);
	}

	public void save(T t) {
		logger.info("salvando " + t);
		session.save(t);
	}

	protected Session getSession() {
		return session;
	}

}
