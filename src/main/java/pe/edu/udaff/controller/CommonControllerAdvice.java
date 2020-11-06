package pe.edu.udaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pe.edu.udaff.entities.Usuario;
import pe.edu.udaff.service.CategoriaService;
import pe.edu.udaff.service.UsuarioService;

@ControllerAdvice
public class CommonControllerAdvice {
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private UsuarioService usuarioService;
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("categorias",categoriaService.findAll());

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!username.equals("anonymousUser")) {
			Usuario u=usuarioService.findByUsuario(username);
			model.addAttribute("userLogged",u);
			model.addAttribute("isAdmin",u.getPerfil().getIdperfil()==1);
		}
	}

}
