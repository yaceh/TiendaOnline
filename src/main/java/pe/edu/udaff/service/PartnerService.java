package pe.edu.udaff.service;

import java.util.List;

import pe.edu.udaff.entities.Partner;

public interface PartnerService {
	public List<Partner> findAll();
	public Partner findById(Integer idpartner);
}
