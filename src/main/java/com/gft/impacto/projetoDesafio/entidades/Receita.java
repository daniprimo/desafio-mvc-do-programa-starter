package com.gft.impacto.projetoDesafio.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "receita")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeDaReceita;
	
	@OneToMany(mappedBy = "receita" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AuxItens> auxItens;
	
	private String ModoDePreparo;

	public Receita() {
		
	}



	@Override
	public String toString() {
		return "Receita [id=" + id + ", nomeDaReceita=" + nomeDaReceita + ", auxItens=" + auxItens + ", ModoDePreparo="
				+ ModoDePreparo + "]";
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

	public List<AuxItens> getAuxItens() {
		return auxItens;
	}

	public void setAuxItens(AuxItens auxItens) {
		this.auxItens.add(auxItens);
	}

	
	


}
