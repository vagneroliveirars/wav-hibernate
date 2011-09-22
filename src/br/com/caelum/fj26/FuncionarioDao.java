package br.com.caelum.fj26;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Classe DAO especifica da entidade Funcionario
 * 
 * @author vagner
 * 
 */
public class FuncionarioDao extends Dao<Funcionario> {

	public FuncionarioDao(Session session) {
		super(session, Funcionario.class);
	}

	public int countTotalFuncionarios() {
		Criteria c = getSession().createCriteria(Funcionario.class);
		c.setProjection(Projections.rowCount());
		return (Integer) c.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscaFuncionarioPorNome(String nome) {
		Criteria c = getSession().createCriteria(Funcionario.class);
		c.add(Restrictions.ilike("nome", nome));
		c.addOrder(Order.asc("email"));
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscaFuncionarioPorNomeEEmail(String nome, String email) {
		Criteria c = getSession().createCriteria(Funcionario.class);
		c.add(Restrictions.ilike("nome", nome));
		c.add(Restrictions.ilike("email", email));
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscaFuncionarioPorNomeOuEmail(String nome, String email) {
		Criteria c = getSession().createCriteria(Funcionario.class);
		Criterion c1 = Restrictions.ilike("nome", nome);
		Criterion c2 = Restrictions.ilike("email", email);
		Criterion c3 = Restrictions.or(c1, c2);
		c.add(c3);
		return c.list();
	}

}