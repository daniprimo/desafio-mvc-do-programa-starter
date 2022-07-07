package com.gft.impacto.projetoDesafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.impacto.projetoDesafio.entidades.UnidadeDeMedida;

@Repository
public interface UnidadeRepository extends JpaRepository<UnidadeDeMedida, Long>{

}
