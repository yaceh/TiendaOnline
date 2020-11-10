package pe.edu.udaff.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.udaff.entities.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Serializable>{
	
	@Query("from Producto where idproducto =?1")
	public Producto findByIdproducto(int idproducto);
	
	@Query("from Producto where feature = ?1 order by idproducto desc")
	public List<Producto> findByFeature(byte feature,PageRequest pageRequest);

	@Query("from Producto order by idproducto desc")
	public List<Producto> findLatest(PageRequest pageRequest);

	@Query("from Producto where nombre like %?1%")
	public List<Producto> getProductosByQuery(String query);
	
}
