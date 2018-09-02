package pe.edu.galaxy.training.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.training.ws.rest.entity.Taller;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;
import pe.edu.galaxy.training.ws.rest.repository.inf.TallerRepository;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.TallerService;

@Service("tallerService")
public class TallerServiceImpl implements TallerService {

	@Autowired
	private TallerRepository tallerRepository;

	@Override
	public boolean insert(Taller taller) throws ServiceException {
		try 
		{
			return tallerRepository.insert(taller);
		}catch(RepositoryException ex){
			throw new ServiceException(ex);
		}
	}

	@Override
	public boolean update(Taller taller) throws ServiceException {
		try {
			return tallerRepository.update(taller);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean delete(Taller taller) throws ServiceException {
		try {
			return tallerRepository.delete(taller);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Taller findByObject(Taller taller) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Taller> findByLikeObject(Taller taller) throws ServiceException {
		try {
			return this.tallerRepository.findByLikeObject(taller);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	public TallerRepository getTallerRepository() {
		return tallerRepository;
	}

	public void setTallerRepository(TallerRepository tallerRepository) {
		this.tallerRepository = tallerRepository;
	}

}
