package com.gft.impacto.projetoDesafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.impacto.projetoDesafio.entidades.UnidadeDeMedida;
import com.gft.impacto.projetoDesafio.repository.UnidadeRepository;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	
	public UnidadeDeMedida inserirNoBanco (UnidadeDeMedida unidadeDeMedida) {
		return unidadeRepository.save(unidadeDeMedida);
	}
	
	public List<UnidadeDeMedida> listaDasUnidades () {
		return unidadeRepository.findAll();
	}
	
	public UnidadeDeMedida obterUnidade(Long id) throws Exception {
		Optional<UnidadeDeMedida> unidadeDeMedida = unidadeRepository.findById(id);
		
		if(unidadeDeMedida.isEmpty()) {
			throw new Exception("Unidade não cadastrada");
		}
		
		return unidadeDeMedida.get();
	}
	
	public void excluirUnidade(Long id) {
		unidadeRepository.deleteById(id);
	}

	
}
