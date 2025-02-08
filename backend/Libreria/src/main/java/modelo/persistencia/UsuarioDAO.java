package modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.persistenciaDAO.DAO;

public class UsuarioDAO implements DAO<UsuarioDTO>{
	
	@Override
	public void crear(UsuarioDTO usuario) throws SQLException{
		String sql = "INSERT INTO usuario (nombre, contrasena, correoelectronico, direccionfisica, numerotelefonico, tipo) VALUES (?, ?, ?, ?, ?, ?)";
		try(Connection conexion = ConexionDB.getInstance().getConnection();
				PreparedStatement pstmt = conexion.prepareStatement(sql)){
			pstmt.setString(1, usuario.getNombre());
			pstmt.setString(2, usuario.getContrasena());
			pstmt.setString(3, usuario.getCorreoElectronico());
			pstmt.setString(4, usuario.getDireccionFisica());
			pstmt.setString(5, usuario.getNumeroTelefonico());
			pstmt.setString(6, "Usuario");
			pstmt.executeUpdate();
		}
	}

	@Override
	public UsuarioDTO buscarPorNombre(String usuario) throws SQLException{
		String sql = "SELECT * from usuario where nombre = ?";
		try (Connection conn = ConexionDB.getInstance().getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, usuario);
	            try (ResultSet rs = pstmt.executeQuery()) {
	            	if(rs.next()) {
	            		System.out.println(rs.getString("nombre"));
	            		return new UsuarioDTO.Builder()
	            				.setId(rs.getInt("idusuario"))
	                            .setContrasena(rs.getString("contrasena"))
	                            .setNombre(rs.getString("nombre"))
	                            .setCorreoElectronico(rs.getString("correoelectronico"))
	                            .setDireccionFisica(rs.getString("direccionfisica"))
	                            .setNumeroTelefonico(rs.getString("numerotelefonico"))
	                            .build();
	            	};
	                
	                
	            }
	    }
	    return null;
	}

	@Override
	public void eliminarPorID(int id) throws SQLException {
	    String sql = "DELETE FROM usuario WHERE idusuario = ?";
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        pstmt.executeUpdate();
	    }
	}

	@Override
	public void actualizar(UsuarioDTO DTO) throws SQLException {
	    String sql = "UPDATE usuario SET nombre = ?, contrasena = ?, correoelectronico = ?, direccionfisica = ?, numerotelefonico = ? WHERE idusuario = ?";
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, DTO.getNombre());
	        pstmt.setString(2, DTO.getContrasena());
	        pstmt.setString(3, DTO.getCorreoElectronico());
	        pstmt.setString(4, DTO.getDireccionFisica());
	        pstmt.setString(5, DTO.getNumeroTelefonico());
	        pstmt.setInt(6, DTO.getId());
	        pstmt.executeUpdate();
	    }
	}

	@Override
	public UsuarioDTO buscarPorId(int id) throws SQLException {
	    String sql = "SELECT * FROM usuario WHERE idusuario = ?";
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                System.out.println(rs.getString("nombre"));
	                return new UsuarioDTO.Builder()
	                        .setId(rs.getInt("idusuario"))
	                        .setContrasena(rs.getString("contrasena"))
	                        .setNombre(rs.getString("nombre"))
	                        .setCorreoElectronico(rs.getString("correoelectronico"))
	                        .setDireccionFisica(rs.getString("direccionfisica"))
	                        .setNumeroTelefonico(rs.getString("numerotelefonico"))
	                        .build();
	            }
	        }
	    }
	    return null;
	}



}
