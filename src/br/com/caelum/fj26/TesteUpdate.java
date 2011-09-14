package br.com.caelum.fj26;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TesteUpdate {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();

		Funcionario f = new Funcionario();
		f = (Funcionario) s.load(Funcionario.class, 1L);
		f.setNome("Guilherme");

		Transaction t = s.beginTransaction();
		s.update(f);
		t.commit();
	}

}
