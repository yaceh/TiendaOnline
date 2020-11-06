package pe.edu.udaff.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.udaff.entities.Perfil;


@Repository
public interface PerfilDao extends JpaRepository<Perfil, Serializable>{
	
}
