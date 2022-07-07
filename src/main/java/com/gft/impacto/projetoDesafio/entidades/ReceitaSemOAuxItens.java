package com.gft.impacto.projetoDesafio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReceitaSemOAuxItens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeDaReceita;
	
	private String ingrediente;
	
	private String ModoDePreparo;

	public ReceitaSemOAuxItens() {
		
	}



	public String getModoDePreparo() {
		return ModoDePreparo;
	}

	public void setModoDePreparo(String modoDePreparo) {
		ModoDePreparo = modoDePreparo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDaReceita() {
		return nomeDaReceita;
	}

	public void setNomeDaReceita(String nomeDaReceita) {
		this.nomeDaReceita = nomeDaReceita;
	}



	public String getIngrediente() {
		return ingrediente;
	}



	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	

	
	


}
