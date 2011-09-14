package br.com.caelum.fj26;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TesteBusca {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();
		Session s = sf.openSession();

		Funcionario f = (Funcionario) s.load(Funcionario.class, 1L);
		System.out.println(f.getNome());
		System.out.println(f.getId());

	}

}
