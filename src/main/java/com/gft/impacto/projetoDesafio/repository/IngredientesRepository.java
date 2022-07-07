package com.gft.impacto.projetoDesafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.impacto.projetoDesafio.entidades.Ingredientes;

@Repository
public interface IngredientesRepository extends JpaRepository<Ingredientes,Long> {

}
