package com.gft.impacto.projetoDesafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.impacto.projetoDesafio.entidades.Ingredientes;
import com.gft.impacto.projetoDesafio.repository.IngredientesRepository;

@Service
public class IngredientesService {
	
	@Autowired
	private IngredientesRepository ingredientesRepository;

	public Ingredientes salvarIngrediente(Ingredientes ingredientes) {
		return ingredientesRepository.save(ingredientes);
	}
	
	public List<Ingredientes> listarIngredientes() {
		return ingredientesRepository.findAll();	
	}
	
	public Ingredientes obterIngredientes (Long id) throws Exception {
		Optional<Ingredientes> ingredientes = ingredientesRepository.findById(id);
		
		if (ingredientes.isEmpty()) {
			throw new Exception("Ingredientes não encontrado");
		}
		
		return ingredientes.get();
	}
	
	public void excluirIngredientes(Long id) {
		ingredientesRepository.deleteById(id);
	}
	
	
	
}
