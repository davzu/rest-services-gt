package pe.edu.galaxy.training.ws.rest.bean;


public class TallerBean {

	private long id;

	private String nombre;

	private String descripcion;

	public TallerBean() {
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
