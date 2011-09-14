package br.com.caelum.fj26;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TesteInsereContaEFornecedor {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();
		Session s = sf.openSession();

		Fornecedor f = new Fornecedor();
		f.setNome("Lua");

		ContaPagar cp = new ContaPagar();
		// relacionamento
		cp.setFornecedor(f);
		cp.setDescricao("Lápis");
		cp.setData(new GregorianCalendar());
		cp.setValor(50.0);

		Transaction t = s.beginTransaction();
		s.save(f);
		s.save(cp);
		t.commit();
	}

}
