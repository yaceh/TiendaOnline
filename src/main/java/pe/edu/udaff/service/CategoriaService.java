package pe.edu.udaff.service;

import java.util.List;

import pe.edu.udaff.entities.Categoria;

public interface CategoriaService  {
	public List<Categoria> findAll();
	public List<Categoria> getAll();
	public Categoria findByIdCategoria(Integer idcategoria);
}
