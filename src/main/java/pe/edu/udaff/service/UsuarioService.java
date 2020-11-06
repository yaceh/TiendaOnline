package pe.edu.udaff.service;

import java.util.List;

import pe.edu.udaff.entities.Usuario;

public interface UsuarioService {
	
	public Usuario findByIdUsuario(int idusuario);
	
	public List<Usuario> getAll();
	
	public Usuario save(Usuario p);
	
	public Usuario findByUsuario(String usuario);
}
