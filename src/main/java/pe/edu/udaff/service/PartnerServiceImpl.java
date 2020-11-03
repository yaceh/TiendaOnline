package pe.edu.udaff.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.udaff.dao.PartnerDao;
import pe.edu.udaff.entities.Marca;
import pe.edu.udaff.entities.Partner;

@Service("partnerService")
@Transactional
public class PartnerServiceImpl implements PartnerService {
	@Autowired
	private PartnerDao partnerDao;

	@Override
	public List<Partner> findAll() {
		// TODO Auto-generated method stub
		return partnerDao.findAll();
	}

	@Override
	public Partner findById(Integer idpartner) {
		// TODO Auto-generated method stub
		return partnerDao.findById(idpartner);
	}
}
