package com.mast.spring.service;

import java.util.List;

import com.mast.spring.domain.Persona;

public interface PersonaService {

	public List<Persona> listaPersonas();

	public void guardar(Persona persona);

	public void eliminar(Persona persona);

	public Persona encontrarPersona(Persona persona);
}
