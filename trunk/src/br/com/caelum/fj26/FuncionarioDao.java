package br.com.caelum.fj26;

import java.util.List;

import org.hibernate.Session;

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
		// logica para calcular quantas linhas tem no BD
		return 0;
	}

	public List<Funcionario> buscaFuncionarioPorNome(String nome) {
		// logica para buscar pelo nome
		return null;
	}

}
