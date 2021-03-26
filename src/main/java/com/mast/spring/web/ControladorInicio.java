package com.mast.spring.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mast.spring.domain.Persona;
import com.mast.spring.service.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControladorInicio.class);

	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public String inicio(Model model) {

		List<Persona> personas = (List<Persona>) personaService.listaPersonas();

		LOGGER.info("Ejecuntado el controlador Spring MVC");
		model.addAttribute("personas", personas);
		return "index";
	}

	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar";
	}

	@PostMapping("/guardar")
	// @Valid para agregar las validaciones
	public String guardar(@Valid Persona persona, Errors errores) {
		if (errores.hasErrors()) {
			return "modificar";
		}
		personaService.guardar(persona);
		return "redirect:/";
	}

	@GetMapping("/editar/{id_persona}")
	public String editar(Persona persona, Model model) {
		persona = personaService.encontrarPersona(persona);
		model.addAttribute(persona);
		return "modificar";
	}

//	@GetMapping("/eliminar/{id_persona}")
//	public String eliminar(Persona persona) {
//		personaService.eliminar(persona);
//		return "redirect:/";
//
//	}

	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		personaService.eliminar(persona);
		return "redirect:/";

	}

}
