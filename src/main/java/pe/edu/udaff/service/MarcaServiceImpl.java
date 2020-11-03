package pe.edu.udaff.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.udaff.dao.MarcaDao;
import pe.edu.udaff.entities.Marca;

@Service("marcaService")
@Transactional
public class MarcaServiceImpl implements MarcaService {
	@Autowired
	private MarcaDao marcaDao;

	@Override
	public List<Marca> findAll() {
		// TODO Auto-generated method stub
		return marcaDao.findAll();
	}

	@Override
	public Marca findById(Integer idmarca) {
		// TODO Auto-generated method stub
		return marcaDao.findById(idmarca);
	}

}
