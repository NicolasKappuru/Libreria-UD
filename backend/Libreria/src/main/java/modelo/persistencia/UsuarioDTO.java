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
	
	
	public UsuarioDTO(Builder builder) {
	}
	
	public int getId() { return id; }
	
	public String getNombre() { return nombre; }
	
	public String getContrasena() {	return contrasena; }

	public String getCorreoElectronico() { return correoElectronico; }
	
	public String getDireccionFisica() { return direccionFisica; }

	public String getNumeroTelefonico() { return numeroTelefonico; }

	public String getTipo() { return tipo; }
	
	
	//Nuestro Builder para construir DTOs inmutables
	public static class Builder {
        private String nombre;
        private int id; 
        private String contrasena;
        private String correoElectronico;
        private String direccionFisica;
        private String numeroTelefonico;
        private String tipo;

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

        public Builder setTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public UsuarioDTO build() {
            return new UsuarioDTO(this);
        }
    }
}
