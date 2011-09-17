package br.com.caelum.fj26;

import org.hibernate.Session;

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

}
