package br.com.caelum.fj26;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class TesteInsere {

	public static void main(String[] args) {

		Configuration configuration = new AnnotationConfiguration();
		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();
		Session s = sf.openSession();

		Funcionario f = new Funcionario();
		f.setNome("Vagner Silva Oliveira");
		f.setEmail("soliveira.vagner@gmail.com");
		f.setUsuario("vagner");
		f.setSenha("abcde");

		Transaction t = s.beginTransaction();
		s.save(f);
		t.commit();

		s.close();
		sf.close();

	}
}
