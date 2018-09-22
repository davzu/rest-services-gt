package pe.edu.galaxy.training.ws.rest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.ws.rest.entity.Vehiculo;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;
import pe.edu.galaxy.training.ws.rest.repository.inf.VehiculoRepository;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo listarPorPlaca(String placa) throws ServiceException {
        try {
            return vehiculoRepository.listarPorPlaca(placa);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Vehiculo> listarPorAno(int ano) throws ServiceException {
        try {
            return vehiculoRepository.listarPorAno(ano);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean insertar(Vehiculo vehiculo) throws ServiceException {
        try {
            return vehiculoRepository.insertar(vehiculo);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean actualizar(Vehiculo vehiculo) throws ServiceException {
        try {
            return vehiculoRepository.actualizar(vehiculo);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean eliminar(Vehiculo vehiculo) throws ServiceException {
        try {
            return vehiculoRepository.eliminar(vehiculo);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean existePlaca(Vehiculo vehiculo) throws ServiceException {
        try {
            return vehiculoRepository.existePlaca(vehiculo);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

}
