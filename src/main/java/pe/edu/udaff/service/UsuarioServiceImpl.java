package pe.edu.udaff.service;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.udaff.dao.UsuarioDao;
import pe.edu.udaff.entities.Perfil;
import pe.edu.udaff.entities.Usuario;


@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioDao.findByUsuario(username);
		
		if (user == null || !user.getActivo())
			throw new UsernameNotFoundException(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    	Perfil profile=user.getPerfil();
		grantedAuthorities.add(new SimpleGrantedAuthority(profile.getPerfil()));
		
	     return new org.springframework.security.core.userdetails.User(user.getUsuario(),user.getPassword() , grantedAuthorities);
	}

	@Override
	public Usuario findByIdUsuario(int idusuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findByIdUsuario(idusuario);
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	public Usuario save(Usuario p) {
		// TODO Auto-generated method stub
		return usuarioDao.save(p);
	}

	@Override
	public Usuario findByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsuario(usuario);
	}

	@Override
	public void delete(Usuario u) {
		// TODO Auto-generated method stub
		usuarioDao.delete(u);
	}
	

}
