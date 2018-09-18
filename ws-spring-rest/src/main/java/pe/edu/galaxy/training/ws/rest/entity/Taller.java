package pe.edu.galaxy.training.ws.rest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "taller.listar", procedureName = "PKG_TALLER.SP_LISTAR", resultClasses = Taller.class, parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_C_CURSOR", type = void.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class)}),

    @NamedStoredProcedureQuery(name = "taller.insert", procedureName = "PKG_TALLER.SP_INSERTAR", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_ID_TALLER", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DESCRIPCION", type = String.class)

    }),

    @NamedStoredProcedureQuery(name = "taller.update", procedureName = "PKG_TALLER.SP_ACTUALIZAR", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_TALLER", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DESCRIPCION", type = String.class)

    }),

    @NamedStoredProcedureQuery(name = "taller.delete", procedureName = "PKG_TALLER.SP_ELIMINAR", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_TALLER", type = Integer.class)

    })

})
@Entity(name = "TALLER")
public class Taller implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TALLER")
    private long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Taller() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Taller [id=" + id + ", nombre=" + nombre + ", descripcion="
                + descripcion + "]";
    }

}
