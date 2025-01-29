package modelo.persistencia;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String contrasena;
	
	private String correoElectronico;
	private String direccionFisica;
	private String numeroTelefonico;
	private String tipo;
	
	
	public UsuarioDTO() {
		
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
	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
