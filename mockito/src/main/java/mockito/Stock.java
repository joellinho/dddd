package mockito;

public class Stock {
	private String id;
	private String nombre;
	private int cantidad;
	
	
	
	public Stock(String id, String nombre, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	protected String getId() {
		return id;
	}
	protected void setId(String id) {
		this.id = id;
	}
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected int getCantidad() {
		return cantidad;
	}
	protected void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
