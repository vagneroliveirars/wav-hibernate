package br.com.caelum.fj26;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TesteInsereProduto {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();
		Session s = sf.openSession();

		Produto p = new Produto();
		p.setDescricao("Desktop Dell");

		Transaction t = s.beginTransaction();
		s.save(p);
		t.commit();

		s.close();
		sf.close();
	}

}
