	package com.gft.impacto.projetoDesafio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredientes")
public class Ingredientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeDoIngrediente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoIngrediente() {
		return nomeDoIngrediente;
	}

	public void setNomeDoIngrediente(String nomeDoIngrediente) {
		this.nomeDoIngrediente = nomeDoIngrediente;
	}
	
	
	
}
