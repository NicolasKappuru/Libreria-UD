package controlador;

import java.sql.SQLException;

import modelo.persistencia.UsuarioDAO;
import modelo.persistencia.UsuarioDTO;

public class GestorUsuarios {
	
	private UsuarioDAO usuarioDAO;
	
	public GestorUsuarios() {
		usuarioDAO = new UsuarioDAO();
	}

	public UsuarioDTO construirUsuario(String[] info) {
		UsuarioDTO.Builder usuario = new UsuarioDTO.Builder();
	    
	    for (String pair : info) {
	        String[] entry = pair.split(":");
	        String key = entry[0].trim();
	        String value = entry[1].trim();
	        switch (key) {
	            case "nombre":  
	            	usuario.setNombre(value);
	                break;
	            case "idusuario":
	            	usuario.setId(Integer.parseInt(value)); 
	            	break; 
	            case "contrasena":
	            	usuario.setContrasena(value);
	                break;
	            case "correo":
	            	usuario.setCorreoElectronico(value);
	                break;
	            case "direccion":
	                usuario.setDireccionFisica(value);
	                break;
	            case "telefono":
	            	usuario.setNumeroTelefonico(value);
	                break;
	            case "tipo":
	            	usuario.setTipo(value);
	            	break;
	        }
        }
	    return usuario.build();
	}
	
	public String registrarUsuario(String[] info){
		
		UsuarioDTO usuario = construirUsuario(info);
		try {
			UsuarioDTO encontrado = usuarioDAO.buscarPorNombre(usuario);
			if(encontrado == null) {
				try {
					usuarioDAO.crear(usuario);
					return "Creado";
				} catch (SQLException e) {
					return "Error";
				}
			}else {
				return "Nombre de usuario ya existe";
			}
		} catch (SQLException e) {
			return "Error: " +e;
		}
		
	}
	
	public String loginUsuario(String[] info) {
		
		UsuarioDTO usuario = construirUsuario(info);
		try {
			UsuarioDTO encontrado = usuarioDAO.buscarPorNombre(usuario);
			if(encontrado != null) {
				if(usuario.getContrasena().equals(encontrado.getContrasena())) {
					return "{\"token\": \""+JwtUtil.generarToken(usuario.getNombre())+"\"}";
				}else {
					return "Contraseña invalida";
				}
			}else {
				return "Nombre de usuario no existe";
			}
		} catch (SQLException e) {
			return "Error: " +e;
		}
	}
}
