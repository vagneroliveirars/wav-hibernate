package br.com.caelum.fj26;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
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
	
	@SuppressWarnings("unchecked")
	public List<Object[]> listaFornecedorValor(int qtd) {
		Criteria c = getSession().createCriteria(ContaPagar.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.groupProperty("fornecedor"));
		pl.add(Projections.groupProperty("pago"));
		pl.add(Projections.sum("valor"), "soma");
		c.setProjection(pl);
		c.addOrder(Order.desc("soma"));
		c.setMaxResults(qtd);
		return c.list();
	}

}
