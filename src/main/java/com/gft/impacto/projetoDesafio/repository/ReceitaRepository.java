package com.gft.impacto.projetoDesafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.impacto.projetoDesafio.entidades.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita,Long>{

}
