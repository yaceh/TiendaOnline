package pe.edu.udaff.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pe.edu.udaff.dao.ProductoDao;
import pe.edu.udaff.entities.Producto;

@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public Producto findByIdproducto(int idproducto) {
		// TODO Auto-generated method stub
		return productoDao.findByIdproducto(idproducto);
	}

	@Override
	public List<Producto> findByFeature(byte feature, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return productoDao.findByFeature(feature, pageRequest);
	}

	@Override
	public List<Producto> findLatest(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return productoDao.findLatest(pageRequest);
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		
		return productoDao.findAll();
	}

	@Override
	public Producto save(Producto p) {
		// TODO Auto-generated method stub
		return productoDao.save(p);
	}

}
