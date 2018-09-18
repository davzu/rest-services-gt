package pe.edu.galaxy.training.ws.rest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.ws.rest.entity.Vehiculo;
import pe.edu.galaxy.training.ws.rest.repository.inf.VehiculoRepository;
import pe.edu.galaxy.training.ws.rest.service.inf.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @Override
    public Vehiculo listarPorPlaca(String placa) {
        return vehiculoRepository.listarPorPlaca(placa);
    }

    @Override
    public List<Vehiculo> listarPorAno(int ano) {
        return vehiculoRepository.listarPorAno(ano);
    }

    @Override
    public boolean insertar(Vehiculo vehiculo) {
        return vehiculoRepository.insertar(vehiculo);
    }

    @Override
    public boolean actualizar(Vehiculo vehiculo) {
        return vehiculoRepository.actualizar(vehiculo);
    }

    @Override
    public boolean eliminar(Vehiculo vehiculo) {
        return vehiculoRepository.eliminar(vehiculo);
    }

}
