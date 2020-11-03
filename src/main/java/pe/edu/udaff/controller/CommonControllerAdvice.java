package pe.edu.udaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pe.edu.udaff.service.CategoriaService;

@ControllerAdvice
public class CommonControllerAdvice {
	@Autowired
	private CategoriaService categoriaService;
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("categorias",categoriaService.findAll());
	}

}
