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
                    name = "vehiculo.listar.por.placa",
                    procedureName = "PKG_VEHICULO.SP_LISTAR_POR_PLACA",
                    resultClasses = Vehiculo.class,
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_C_CURSOR", type = void.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_PLACA", type = String.class)
                    }
            ),
            @NamedStoredProcedureQuery(
                    name = "vehiculo.listar.por.ano",
                    procedureName = "PKG_VEHICULO.SP_LISTAR_POR_ANO",
                    resultClasses = Vehiculo.class,
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_C_CURSOR", type = void.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ANO", type = Integer.class)
                    }
            ),
            @NamedStoredProcedureQuery(
                    name = "vehiculo.insertar",
                    procedureName = "PKG_VEHICULO.SP_INSERTAR",
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_CODIGO", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_PLACA", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_MARCA", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_MODELO", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ANO", type = Integer.class)
                    }
            ),
            @NamedStoredProcedureQuery(
                    name = "vehiculo.actualizar",
                    procedureName = "PKG_VEHICULO.SP_ACTUALIZAR",
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CODIGO", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_PLACA", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_MARCA", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_MODELO", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ANO", type = Integer.class)
                    }
            ),
            @NamedStoredProcedureQuery(
                    name = "vehiculo.eliminar",
                    procedureName = "PKG_VEHICULO.SP_ELIMINAR",
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CODIGO", type = Integer.class)
                    }
            ),
            @NamedStoredProcedureQuery(
                    name = "vehiculo.validar.placa",
                    procedureName = "PKG_VEHICULO.SP_VALIDAR_PLACA",
                    parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_NUM", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CODIGO", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_PLACA", type = String.class)
                    }
            )
        }
)

@Entity(name = "VEHICULO")
public class Vehiculo implements Serializable {

    @Id
    @Column(name = "CODIGO")
    private long codigo;
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "ANO")
    private int ano;
    @Column(name = "ESTADO")
    private String estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
