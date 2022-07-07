package com.gft.impacto.projetoDesafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.impacto.projetoDesafio.entidades.ReceitaSemOAuxItens;
import com.gft.impacto.projetoDesafio.repository.Receita2Repository;

@Service
public class Receita2Service {

	@Autowired
	private Receita2Repository receita2Repository;
	
	public ReceitaSemOAuxItens salvarReceita (ReceitaSemOAuxItens receitaSemOAuxItens) {
		return receita2Repository.save(receitaSemOAuxItens);
	}
	
	public List<ReceitaSemOAuxItens> ListarReceitas () {
		return receita2Repository.findAll();
	}
	
	public ReceitaSemOAuxItens obterReceita (Long id) throws Exception {
		Optional<ReceitaSemOAuxItens> listaReceitas = receita2Repository.findById(id);
		
		if(listaReceitas.isEmpty()) {
			throw new Exception("ingredientes não encontrados");
		}
		
		return listaReceitas.get();
	}
	
	public void excluirReceita (Long id) {
		receita2Repository.deleteById(id);
	}
	
	
	
	
	
}
