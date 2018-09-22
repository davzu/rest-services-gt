package pe.edu.galaxy.training.ws.rest.repository.inf;

import java.util.List;
import pe.edu.galaxy.training.ws.rest.entity.Vehiculo;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;

public interface VehiculoRepository {

    public Vehiculo listarPorPlaca(String placa) throws RepositoryException;

    public List<Vehiculo> listarPorAno(int ano) throws RepositoryException;

    public boolean insertar(Vehiculo vehiculo) throws RepositoryException;

    public boolean actualizar(Vehiculo vehiculo) throws RepositoryException;

    public boolean eliminar(Vehiculo vehiculo) throws RepositoryException;

    public boolean existePlaca(Vehiculo vehiculo) throws RepositoryException;

}
