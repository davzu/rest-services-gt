package pe.edu.galaxy.training.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;
import pe.edu.galaxy.training.ws.rest.repository.inf.ClienteRepository;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.ClienteService;

@Service("clienteService")
public class ClienteServieImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteServieImpl() {

	}

	@Override
	public boolean insert(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteRepository().insert(cliente);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean update(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteRepository().update(cliente);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean delete(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteRepository().delete(cliente);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Cliente findByObject(Cliente cliente) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findByLikeObject(Cliente cliente)
			throws ServiceException {
		try {
			return this.getClienteRepository().findByLikeObject(cliente);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Cliente findByRUC(String ruc) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteRepository getClienteRepository() {
		return clienteRepository;
	}

	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<Cliente> findByLikeRZ(String rz) throws ServiceException {
		try {
			return this.getClienteRepository().findByLikeRZ(rz);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean validarRazonSocial(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteRepository().validarRazonSocial(cliente);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean validarRuc(Cliente cliente) throws ServiceException {
		try {
			return this.getClienteRepository().validarRuc(cliente);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

}
