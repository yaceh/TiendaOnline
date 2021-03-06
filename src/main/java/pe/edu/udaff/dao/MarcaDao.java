package pe.edu.udaff.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.udaff.entities.Marca;

@Repository
public interface MarcaDao extends JpaRepository<Marca, Serializable>{
	
	@Query("from Marca where idmarca = ?1")
	public Marca findById(Integer idmarca);
	
}
