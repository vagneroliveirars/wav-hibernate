package br.com.caelum.fj26;

import org.hibernate.Session;

/**
 * Classe de teste que busca um fornecedor atraves de sua chave primaria
 * 
 * @author vagner
 * 
 */
public class TestaDao {
	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();
		Dao<Funcionario> funcionarioDao = new Dao<Funcionario>(session, Funcionario.class);

		Funcionario f = funcionarioDao.load(1L);
		System.out.println(f.getNome());
	}
}
