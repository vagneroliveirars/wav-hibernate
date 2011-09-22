package br.com.caelum.fj26;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 * Classe DAO especifica da entidade ContaPagar
 * 
 * @author vagner
 * 
 */
public class ContaPagarDao extends Dao<ContaPagar> {

	public ContaPagarDao(Session session) {
		super(session, ContaPagar.class);
	}
	
	// calcula a media do valor
	public double avgValor() {
		Criteria c = getSession().createCriteria(ContaPagar.class);
		c.setProjection(Projections.avg("valor"));
		return (Double) c.uniqueResult();
	}
	
	// calcula a soma do valor
	public double sumValor() {
		Criteria c = getSession().createCriteria(ContaPagar.class);
		c.setProjection(Projections.sum("valor"));
		return (Double) c.uniqueResult();
	}

}
