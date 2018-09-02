package pe.edu.galaxy.training.ws.rest.entity;

import java.io.Serializable;

import javax.persistence.*;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="cliente.findByLikeObject", 
					procedureName="PKG_CLIENTE.SP_LISTAR",
					resultClasses= Cliente.class,
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class )
						}					
				),
//				@NamedStoredProcedureQuery(
//						name="cliente.findByLikeRZ", 
//						procedureName="PKG_CLIENTE.SP_LISTAR_X_RZ",
//						resultClasses= Cliente.class,
//						parameters={
//									@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_C_CURSOR", type=void.class ),
//									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RAZON_SOCIAL", type=String.class )
//							}					
//				),
				@NamedStoredProcedureQuery(
						name="cliente.insert", 
						procedureName="PKG_CLIENTE.SP_INSERTAR",
						parameters={
									@StoredProcedureParameter(mode=ParameterMode.OUT,name="P_ID_CLIENTE", type=Integer.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RAZON_SOCIAL", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_RUC", type=String.class ),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="P_DIRECCION", type=String.class )
									
							}					
				)

		}
		)
@Entity (name="CLIENTE")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CLIENTE")
	private long idCliente;

	@Column(name="DIRECCION")
	private String direccion;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="RAZON_SOCIAL")
	private String razonSocial;

	@Column(name="RUC")
	private String ruc;

	public Cliente() {
	}

	public long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", direccion=" + direccion
				+ ", estado=" + estado + ", razonSocial=" + razonSocial
				+ ", ruc=" + ruc + "]";
	}

}