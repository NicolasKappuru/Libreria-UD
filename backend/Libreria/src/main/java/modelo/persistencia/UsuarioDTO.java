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
	
	
	public UsuarioDTO(Builder builder) {
		this.id = builder.id;
        this.nombre = builder.nombre;
        this.contrasena = builder.contrasena;
        this.correoElectronico = builder.correoElectronico;
        this.direccionFisica = builder.direccionFisica;
        this.numeroTelefonico = builder.numeroTelefonico;
	}
	
	public int getId() { return id; }
	
	public String getNombre() { return nombre; }
	
	public String getContrasena() {	return contrasena; }

	public String getCorreoElectronico() { return correoElectronico; }
	
	public String getDireccionFisica() { return direccionFisica; }

	public String getNumeroTelefonico() { return numeroTelefonico; }	
	
	//Nuestro Builder para construir DTOs inmutables
	public static class Builder {
        private String nombre;
        private int id; 
        private String contrasena;
        private String correoElectronico;
        private String direccionFisica;
        private String numeroTelefonico;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        
        public Builder setId(int value) {
        	this.id = value; 
        	return this; 
        }

        public Builder setContrasena(String contrasena) {
            this.contrasena = contrasena;
            return this;
        }

        public Builder setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
            return this;
        }

        public Builder setDireccionFisica(String direccionFisica) {
            this.direccionFisica = direccionFisica;
            return this;
        }

        public Builder setNumeroTelefonico(String numeroTelefonico) {
            this.numeroTelefonico = numeroTelefonico;
            return this;
        }


        public UsuarioDTO build() {
            return new UsuarioDTO(this);
        }
    }
}
