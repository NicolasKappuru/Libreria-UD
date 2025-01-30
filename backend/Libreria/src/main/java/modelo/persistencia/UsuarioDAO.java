package modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	
	public void crear(UsuarioDTO usuario) throws SQLException{
		String sql = "INSERT INTO usuario (nombre, contrasena, correoelectronico, direccionfisica, numerotelefonico, tipo) VALUES (?, ?, ?, ?, ?, ?)";
		try(Connection conexion = ConexionDB.getInstance().getConnection();
				PreparedStatement pstmt = conexion.prepareStatement(sql)){
			pstmt.setString(1, usuario.getNombre());
			pstmt.setString(2, usuario.getContrasena());
			pstmt.setString(3, usuario.getCorreoElectronico());
			pstmt.setString(4, usuario.getDireccionFisica());
			pstmt.setString(5, usuario.getNumeroTelefonico());
			pstmt.setString(6, usuario.getTipo());
			pstmt.executeUpdate();
		}
	}
	
	public UsuarioDTO buscarPorNombre(UsuarioDTO usuario) throws SQLException{
		String sql = "SELECT * from usuario where nombre = ?";
		try (Connection conn = ConexionDB.getInstance().getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, usuario.getNombre());
	            try (ResultSet rs = pstmt.executeQuery()) {
	            	if(rs.next()) {
	            		return new UsuarioDTO.Builder()
	                            .setId(rs.getInt("idusuario"))  // Agrega este setter en el Builder si falta
	                            .setContrasena(rs.getString("contrasena"))
	                            .setNombre(rs.getString("nombre"))
	                            .setCorreoElectronico(rs.getString("correoelectronico"))
	                            .setDireccionFisica(rs.getString("direccionfisica"))
	                            .setNumeroTelefonico(rs.getString("numerotelefonico"))
	                            .setTipo(rs.getString("tipo"))
	                            .build();
	            	};
	                
	                
	            }
	    }
	    return null;
	}
}
