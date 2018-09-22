package pe.edu.galaxy.training.ws.rest.service.inf;

import java.util.List;
import pe.edu.galaxy.training.ws.rest.entity.Vehiculo;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;

public interface VehiculoService {

    public Vehiculo listarPorPlaca(String placa) throws ServiceException;

    public List<Vehiculo> listarPorAno(int ano) throws ServiceException;

    public boolean insertar(Vehiculo vehiculo) throws ServiceException;

    public boolean actualizar(Vehiculo vehiculo) throws ServiceException;

    public boolean eliminar(Vehiculo vehiculo) throws ServiceException;

    public boolean existePlaca(Vehiculo vehiculo) throws ServiceException;
}
