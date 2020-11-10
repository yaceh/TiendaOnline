package pe.edu.udaff.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import pe.edu.udaff.entities.Producto;

public interface ProductoService {
	
	public Producto findByIdproducto(int idproducto);
	
	public List<Producto> findByFeature(byte feature,PageRequest pageRequest);

	public List<Producto> findLatest(PageRequest pageRequest);
	
	public List<Producto> getAll();
	
	public Producto save(Producto p);
	
	public void delete(Producto p);

	public List<Producto> getProductosByQuery(String query);
}
