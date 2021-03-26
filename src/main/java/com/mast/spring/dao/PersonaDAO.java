package com.mast.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.mast.spring.domain.Persona;

public interface PersonaDAO extends CrudRepository<Persona, Long>{

	
}
