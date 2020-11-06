package pe.edu.udaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.udaff.entities.Perfil;
import pe.edu.udaff.entities.Usuario;
import pe.edu.udaff.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;
	@GetMapping("/login")
	public String home(Model model) {
		return "views/public/login/index";
	}
	@ResponseBody
	@PostMapping("/registro")
	public boolean registro(@RequestBody Usuario usuario) {
		if(usuarioService.findByUsuario(usuario.getUsuario())==null) {
			Perfil p= new Perfil();
			
			p.setIdperfil(2);
			
			usuario.setPerfil(p);
			
			BCryptPasswordEncoder b= new BCryptPasswordEncoder();
			
			usuario.setPassword(b.encode(usuario.getPassword()));
			
			usuario.setActivo(true);
			usuarioService.save(usuario);
			
			return true;
		}else {
			return false;
		}
	}
	
}
