package br.com.caelum.fj26;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Classe que representa a entidade Produto
 * 
 * @author vagner
 * 
 */
@Entity
public class Produto {

	@Id
	@SequenceGenerator(name = "PRODUTO_ID", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_ID")
	@Column(name = "ID")
	private Long id;
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
