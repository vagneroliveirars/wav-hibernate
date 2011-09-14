package br.com.caelum.fj26;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TesteBuscaProdutoPorId {
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();
		Session s = sf.openSession();
		
		Produto encontrado = (Produto) s.load(Produto.class, new Long(1));
		System.out.println("O select já foi feito");
		System.out.println(encontrado.getDescricao());
		System.out.println(encontrado.getClass().getName());
	}

}
