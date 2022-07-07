	package com.gft.impacto.projetoDesafio.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auxiliar")
@IdClass(itens.class)
public class AuxItens implements Serializable {
	
	@Id
	@ManyToOne
	private Ingredientes ingredientes;
	
	private String quantidade;
	
	@Id
	@ManyToOne
	private UnidadeDeMedida unidadeDeMedida;
	
	@ManyToOne
	@JoinColumn(name = "receita_id", nullable = true)
	private Receita receita;
	
	
	
	public Ingredientes getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Ingredientes ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public UnidadeDeMedida getUnidadeDeMedida() {
		return unidadeDeMedida;
	}
	public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	
	
	
	
	
}
