package br.com.caelum.fj26;

import java.util.List;

import org.hibernate.Session;

public class TesteAgrupaResultados {

	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();
		ContaPagarDao contaPagarDao = new ContaPagarDao(session);
		List<Object[]> lista = contaPagarDao.listaFornecedorValor(10);
		for (Object[] fv : lista) {
			Fornecedor f = (Fornecedor) fv[0];
			String situacao;
			if ((Boolean) fv[1]) {
				situacao = "Pagas";				
			} else {
				situacao = "N�o pagas";
			}
			System.out.println(f.getNome() + " - "
					+ f.getDescricao() 
					+ " - " + situacao);
			System.out.printf("%.2f", fv[2]);
			System.out.println();
		}
	}
}
