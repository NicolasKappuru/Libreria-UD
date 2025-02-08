package modelo;

public class Usuario {
	
	private int id;
	private String nombre;
	private String correoElectronico;
	private String direccionFisica;
	private String numeroTelefonico;
	
	public Usuario() {
		
	}

	public Usuario(int id, String nombre, String correoElectronico, String direccionFisica, String numeroTelefonico) {
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.direccionFisica = direccionFisica;
		this.numeroTelefonico = numeroTelefonico;
	}

	public Usuario(String nombre, String correoElectronico, String direccionFisica, String numeroTelefonico) {
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.direccionFisica = direccionFisica;
		this.numeroTelefonico = numeroTelefonico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccionFisica() {
		return direccionFisica;
	}

	public void setDireccionFisica(String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	
	
	
	
}
