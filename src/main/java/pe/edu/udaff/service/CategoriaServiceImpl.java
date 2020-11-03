package pe.edu.udaff.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.udaff.dao.CategoriaDao;
import pe.edu.udaff.entities.Categoria;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDao categoriaDao;
	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return categoriaDao.findAll();
	}
	@Override
	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return categoriaDao.getAll();
	}
	@Override
	public Categoria findByIdCategoria(Integer idcategoria) {
		// TODO Auto-generated method stub
		return categoriaDao.findByIdCategoria(idcategoria);
	}
	
}
