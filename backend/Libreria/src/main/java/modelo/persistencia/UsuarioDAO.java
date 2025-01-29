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
		UsuarioDTO encontrado;
		try (Connection conn = ConexionDB.getInstance().getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, usuario.getNombre());
	            try (ResultSet rs = pstmt.executeQuery()) {
	            	if(rs.next()) {
	            		encontrado = new UsuarioDTO();
	            		encontrado.setId(rs.getInt("idusuario"));
	            		encontrado.setContrasena(rs.getString("contrasena"));
	            		encontrado.setNombre(rs.getString("nombre"));
	            		encontrado.setCorreoElectronico(rs.getString("correoelectronico"));
	            		encontrado.setDireccionFisica(rs.getString("direccionfisica"));
	            		encontrado.setNumeroTelefonico(rs.getString("numerotelefonico"));
	            		encontrado.setTipo(rs.getString("tipo"));
	            		return encontrado; 
	            	};
	                
	                
	            }
	    }
	    return null;
	}
}
