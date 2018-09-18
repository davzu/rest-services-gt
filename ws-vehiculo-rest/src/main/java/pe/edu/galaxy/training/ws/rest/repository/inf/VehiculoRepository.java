package pe.edu.galaxy.training.ws.rest.repository.inf;

import java.util.List;
import pe.edu.galaxy.training.ws.rest.entity.Vehiculo;

public interface VehiculoRepository {

    public Vehiculo listarPorPlaca(String placa);

    public List<Vehiculo> listarPorAno(int ano);

    public boolean insertar(Vehiculo vehiculo);

    public boolean actualizar(Vehiculo vehiculo);

    public boolean eliminar(Vehiculo vehiculo);

}
