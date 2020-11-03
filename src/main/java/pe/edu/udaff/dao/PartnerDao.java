package pe.edu.udaff.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.udaff.entities.Partner;

@Repository
public interface PartnerDao extends JpaRepository<Partner, Serializable>{

	@Query("from Partner where idpartner = ?1")
	public Partner findById(Integer idpartner);
}
