package br.com.caelum.fj26;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Classe DAO especifica da entidade Fornecedor
 * 
 * @author vagner
 * 
 */
public class FornecedorDao extends Dao<Fornecedor> {

	public FornecedorDao(Session session) {
		super(session, Fornecedor.class);
	}

	/**
	 * Busca um fornecedor com determinado nome. Nao e Case Sensitive
	 * 
	 * @param nome
	 * @return lista de fornecedores
	 */
	@SuppressWarnings("unchecked")
	public List<Fornecedor> buscaFornecedorPorNome(String nome) {
		Query q = getSession().createQuery("select f from " 
				+ Fornecedor.class.getName()
				+ " as f where lower(f.nome) like lower(:nome)");
		q.setParameter("nome", "%" + nome + "%");
		return q.list();
	}

}
