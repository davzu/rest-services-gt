package pe.edu.galaxy.training.rest.bean;


public class ClienteBean  {
		
	private long idCliente;

	private String direccion;

	private String estado;

	
	private String razonSocial;

	private String ruc;

	public ClienteBean() {
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
		return "ClienteBean [idCliente=" + idCliente + ", direccion="
				+ direccion + ", estado=" + estado + ", razonSocial="
				+ razonSocial + ", ruc=" + ruc + "]";
	}

	
}