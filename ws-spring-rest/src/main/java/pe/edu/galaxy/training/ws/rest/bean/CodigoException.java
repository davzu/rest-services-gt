package pe.edu.galaxy.training.ws.rest.bean;

import java.util.Date;

import pe.edu.galaxy.training.ws.rest.util.UtilProperties;


public class CodigoException {
	
	private String codigo;
	
	private String descripcion;
	
	private String fechaHora;
	
	private String retorno;

	public CodigoException() {
		super();
	}
	
	public CodigoException(String codigo) {
		super();
		//int pos=codigo.indexOf(":");
		//System.out.println("pos "+pos);
		String result = UtilProperties.getKeyCode(codigo);
		String data[]=result.split(":");
		System.out.println("data "+data);
		if (data.length>=2) {
			this.setCodigo(data[0]);
			this.setDescripcion(result.substring(data[0].length()));
			this.setFechaHora(new Date().toString());
			this.setRetorno("");
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	@Override
	public String toString() {
		return "CodigoException [codigo=" + codigo + ", descripcion="
				+ descripcion + ", fechaHora=" + fechaHora + ", retorno="
				+ retorno + "]";
	}
	
}
