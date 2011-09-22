package br.com.caelum.fj26;

import java.util.List;

import org.hibernate.Session;

public class TestaPesquisaILike {
	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();
		FuncionarioDao funcionarioDao = new FuncionarioDao(session);
		List<Funcionario> lista = funcionarioDao.buscaFuncionarioPorNome("%Oli%");
		for (Funcionario f : lista) {
			System.out.println(f.getNome());
		}
	}
}
