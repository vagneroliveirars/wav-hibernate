package br.com.caelum.fj26;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	/**
	 * Calcula a media do valor das contas a pagar
	 * 
	 * @return a media do valor
	 */
	public double avgValor() {
		Criteria c = getSession().createCriteria(ContaPagar.class);
		c.setProjection(Projections.avg("valor"));
		return (Double) c.uniqueResult();
	}

	/**
	 * Calcula a soma do valor das contas a pagar
	 * 
	 * @return a soma do valor
	 */
	public double sumValor() {
		Criteria c = getSession().createCriteria(ContaPagar.class);
		c.setProjection(Projections.sum("valor"));
		return (Double) c.uniqueResult();
	}

	/**
	 * Agrupa resultados em Arrays
	 * 
	 * @param qtd
	 * @return lista com Arrays de objetos
	 */
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

	/**
	 * Busca as contas de um fornecedor com determinado nome
	 * 
	 * @param nome
	 * @return lista de contas a pagar
	 */
	@SuppressWarnings("unchecked")
	public List<ContaPagar> listaContasDoFornecedor(String nome) {
		Query q = getSession().createQuery("select cp from " 
				+ ContaPagar.class.getName()
				+ " as cp where cp.fornecedor.nome like :nome"
				+ " order by cp.fornecedor.nome");
		q.setParameter("nome", nome);
		return q.list();
	}

	/**
	 * Busca as contas de um fornecedor com determinado nome, mas somente as que
	 * tem valor maior que 500
	 * 
	 * @param nome
	 * @return lista de contas a pagar
	 */
	@SuppressWarnings("unchecked")
	public List<ContaPagar> contasDoFornecedorComValorAlto(String nome) {
		Query q = getSession().createQuery("select cp from " 
				+ ContaPagar.class.getName()
				+ " as cp where cp.fornecedor.nome like :nome"
				+ " and cp.valor > 500"
				+ " order by cp.fornecedor.nome");
		q.setParameter("nome", nome);
		return q.list();
	}

	/**
	 * Busca as contas de um fornecedor com determinado nome ou as contas com
	 * valor maior que 500
	 * 
	 * @param nome
	 * @return lista de contas a pagar
	 */
	@SuppressWarnings("unchecked")
	public List<ContaPagar> buscaContasDeFornecedores(String nome) {
		Query q = getSession().createQuery("select cp from " 
				+ ContaPagar.class.getName()
				+ " as cp where cp.fornecedor.nome like :nome"
				+ " or cp.valor > 500"
				+ " order by cp.fornecedor.nome");
		q.setParameter("nome", nome);
		return q.list();
	}

	public double mediaDasContas() {
		Query q = getSession().createQuery("select avg(cp.valor) from " 
				+ ContaPagar.class.getName());
		return (Double) q.uniqueResult();
	}

	public double somaDasContas() {
		Query q = getSession().createQuery("select sum(cp.valor) from " 
				+ ContaPagar.class.getName() + " as cp");
		return (Double) q.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ContaPagar> paginarContas(String nome, int maxSize, int first) {
		Query q = getSession().createQuery("select cp from " 
				+ ContaPagar.class.getName()
				+ " as cp where cp.fornecedor.nome like :nome"
				+ " order by cp.fornecedor.nome");
		q.setMaxResults(maxSize);
		q.setFirstResult(first);
		q.setParameter("nome", nome);
		return q.list();
	}

}
