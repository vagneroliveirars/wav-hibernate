package br.com.caelum.fj26;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TesteBuscaContaPagar {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();

		ContaPagar contaPagar = (ContaPagar) s.load(ContaPagar.class, 1L);
		System.out.println(contaPagar.getFornecedor().getNome());

	}

}
