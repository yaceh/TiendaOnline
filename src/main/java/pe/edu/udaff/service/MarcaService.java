package pe.edu.udaff.service;

import java.util.List;

import pe.edu.udaff.entities.Marca;

public interface MarcaService {
	public List<Marca> findAll();
	public Marca findById(Integer idmarca);
}
