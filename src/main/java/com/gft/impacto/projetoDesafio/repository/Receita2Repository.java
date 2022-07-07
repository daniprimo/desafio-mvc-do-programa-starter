package com.gft.impacto.projetoDesafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.impacto.projetoDesafio.entidades.ReceitaSemOAuxItens;

@Repository
public interface Receita2Repository extends JpaRepository<ReceitaSemOAuxItens, Long> {

}
