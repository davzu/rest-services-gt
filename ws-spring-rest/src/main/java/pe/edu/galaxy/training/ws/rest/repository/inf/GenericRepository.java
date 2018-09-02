package pe.edu.galaxy.training.ws.rest.repository.inf;

import java.util.List;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;

public interface GenericRepository<T> {
	
	public boolean 	insert(T prmObject) throws RepositoryException;

	public boolean 	update(T prmObject) throws RepositoryException;

	public boolean 	delete(T prmObject) throws RepositoryException;
	
	public T 	findByObject(T prmObject) throws RepositoryException;
	
	public List<T>  findByLikeObject(T prmObject) throws RepositoryException;

}
