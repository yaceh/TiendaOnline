package pe.edu.udaff.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.udaff.entities.Categoria;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Serializable> {
	@Query("from Categoria where parentid = 0")
	public List<Categoria> findAll();

	@Query("from Categoria")
	public List<Categoria> getAll();

	@Query("from Categoria where idcategoria = ?1")
	public Categoria findByIdCategoria(Integer idcategoria);

}
