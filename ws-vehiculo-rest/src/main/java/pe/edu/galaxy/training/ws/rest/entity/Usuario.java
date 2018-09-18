package pe.edu.galaxy.training.ws.rest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries(
        {
            @NamedStoredProcedureQuery(
                    name = "usuario.validar.credenciales",
                    procedureName = "PKG_USUARIO.SP_VALIDAR_CREDENCIALES",
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NUM", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_USUARIO", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CLAVE", type = String.class)
                    }
            )
        }
)

@Entity(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @Column(name = "ID_USUARIO")
    private String id;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "ESTADO")
    private String estado;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
