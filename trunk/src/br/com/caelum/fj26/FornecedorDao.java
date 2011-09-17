package br.com.caelum.fj26;

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

}
