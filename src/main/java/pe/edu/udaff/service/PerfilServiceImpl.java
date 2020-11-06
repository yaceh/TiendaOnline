package pe.edu.udaff.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.udaff.dao.PerfilDao;
import pe.edu.udaff.entities.Perfil;

@Service("perfilService")
@Transactional
public class PerfilServiceImpl implements PerfilService{
	
	@Autowired
	private PerfilDao perfilDao;

	@Override
	public List<Perfil> findAll() {
		// TODO Auto-generated method stub
		return perfilDao.findAll();
	}


}
