package pe.edu.galaxy.training.ws.rest.repository.inf;

import java.util.List;

import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;

public interface ClienteRepository extends GenericRepository<Cliente> {
	
	public Cliente 	findByRUC(String ruc) throws RepositoryException;
	
	public List<Cliente>  findByLikeRZ(String rz) throws RepositoryException;
	
	
}
