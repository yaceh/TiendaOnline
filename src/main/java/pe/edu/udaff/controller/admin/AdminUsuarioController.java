package pe.edu.udaff.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.udaff.entities.Categoria;
import pe.edu.udaff.entities.Marca;
import pe.edu.udaff.entities.Partner;
import pe.edu.udaff.entities.Perfil;
import pe.edu.udaff.entities.Producto;
import pe.edu.udaff.entities.Usuario;
import pe.edu.udaff.service.PerfilService;
import pe.edu.udaff.service.UsuarioService;

@Controller
@RequestMapping("/admin/usuario")
public class AdminUsuarioController {
	

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PerfilService perfilService;

	@GetMapping()
	public String usuario(Model model) {
		model.addAttribute("title", "Admin | Usuario");
		model.addAttribute("perfiles",perfilService.findAll());
		model.addAttribute("usuarios",usuarioService.getAll());
		return "views/admin/usuario/index";
	}
	
	@ResponseBody
	@GetMapping("/{id}")
	public Usuario getProducto(@PathVariable("id") Integer id) {
		Usuario u=usuarioService.findByIdUsuario(id);
		Perfil p= new Perfil();
		p.setPerfil(u.getPerfil().getPerfil());
		p.setIdperfil(u.getPerfil().getIdperfil());
		u.setPerfil(p);
		
		return u;
	}
	
	@ResponseBody
	@PostMapping("agregar")
	public boolean agregarUsuario(@RequestBody Usuario usuario) {
		if(usuarioService.findByUsuario(usuario.getUsuario())==null) {
			BCryptPasswordEncoder b= new BCryptPasswordEncoder();
			usuario.setPassword(b.encode(usuario.getPassword()));
			usuarioService.save(usuario);
			return true;
		}else {
			return false;
		}
	}
	@ResponseBody
	@PostMapping("cambiarActivo")
	public boolean cambiarActivo(@RequestParam(name="id") Integer id) {
		Usuario usAnt=usuarioService.findByIdUsuario(id);
		usAnt.setActivo(!usAnt.getActivo());
		usuarioService.save(usAnt);
		return true;
	}
	@ResponseBody
	@PostMapping("eliminar")
	public boolean eliminarUsuario(@RequestParam(name="id") Integer id) {
		Usuario usAnt=usuarioService.findByIdUsuario(id);
		usuarioService.delete(usAnt);
		return true;
	}

}
