package com.gft.impacto.projetoDesafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.impacto.projetoDesafio.entidades.AuxItens;
import com.gft.impacto.projetoDesafio.repository.AuxItensRepository;

@Service
public class AuxItensService {

	@Autowired
	private AuxItensRepository auxItensRepository;
	
	public AuxItens inserirAux (AuxItens auxItens) {
		return auxItensRepository.save(auxItens);
	}
	
	public List<AuxItens> listarAux () {
		return auxItensRepository.findAll();
	}
	
	public AuxItens obterAux (Long id) throws Exception {
		Optional<AuxItens> auxItens = auxItensRepository.findById(id);
		
		if(auxItens.isEmpty()) {
			throw new Exception("Não foi possivel processar");
		}
		
		
		
		return auxItens.get();
	}
	
	public void excluirAux (Long id) {
		auxItensRepository.deleteById(id);
		
	}
	
	
}
