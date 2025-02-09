package modelo.persistencia;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = UsuarioDTO.Builder.class)
public class UsuarioDTO implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private String nombre;
    private String contrasena;
    private String correoElectronico;
    private String direccionFisica;
    private String numeroTelefonico;

    private UsuarioDTO(Builder builder) {
        this.nombre = builder.nombre;
        this.contrasena = builder.contrasena;
        this.correoElectronico = builder.correoElectronico;
        this.direccionFisica = builder.direccionFisica;
        this.numeroTelefonico = builder.numeroTelefonico;
    }

    public String getNombre() { return nombre; }
    public String getContrasena() { return contrasena; }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getDireccionFisica() { return direccionFisica; }
    public String getNumeroTelefonico() { return numeroTelefonico; }

    public static class Builder {
        private String nombre;
        private String contrasena;
        private String correoElectronico;
        private String direccionFisica;
        private String numeroTelefonico;

        @JsonProperty("nombre")
        public Builder setNombre(String nombre) { this.nombre = nombre; return this; }

        @JsonProperty("contrasena")
        public Builder setContrasena(String contrasena) { this.contrasena = contrasena; return this; }

        @JsonProperty("correo")
        public Builder setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; return this; }

        @JsonProperty("direccion")
        public Builder setDireccionFisica(String direccionFisica) { this.direccionFisica = direccionFisica; return this; }

        @JsonProperty("telefono")
        public Builder setNumeroTelefonico(String numeroTelefonico) { this.numeroTelefonico = numeroTelefonico; return this; }

        public UsuarioDTO build() { return new UsuarioDTO(this); }
    }
}


