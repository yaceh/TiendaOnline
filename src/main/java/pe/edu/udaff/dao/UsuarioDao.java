package pe.edu.udaff.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.udaff.entities.Categoria;
import pe.edu.udaff.entities.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Serializable> {
	public Usuario findByUsuario(String usuario);

	@Query("from Usuario where idusuario= ?1")
	public Usuario findByIdUsuario(Integer idusuario);
}
