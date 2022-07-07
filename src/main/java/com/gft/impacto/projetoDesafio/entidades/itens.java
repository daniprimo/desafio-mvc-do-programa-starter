package com.gft.impacto.projetoDesafio.entidades;

import java.io.Serializable;
import java.util.Objects;


@SuppressWarnings("serial")
public class itens implements Serializable {

	private Long ingredientes;
	private Long unidadeDeMedida;
	
	public itens() {
		
	}

	public itens(Long ingredientes, Long unidadeDeMedida) {
		this.ingredientes = ingredientes;
		this.unidadeDeMedida = unidadeDeMedida;
	}



	public Long getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Long ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Long getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(Long unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingredientes, unidadeDeMedida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		itens other = (itens) obj;
		return Objects.equals(ingredientes, other.ingredientes)
				&& Objects.equals(unidadeDeMedida, other.unidadeDeMedida);
	}
	
	
	
	
	
	
	
}
