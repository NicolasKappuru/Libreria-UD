package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.DocumentoDTO.LibroDTO;
import modelo.persistencia.ConexionDB;

public class LibroDAO implements DAO<LibroDTO>{

	public void crear(LibroDTO libro) throws SQLException {
		String sql = "INSERT INTO libro (iddocumento, numeropaginas, isbn) VALUES (?, ?, ?)";
		try(Connection conexion = ConexionDB.getInstance().getConnection();
			PreparedStatement pstmt = conexion.prepareStatement(sql)){
			
			pstmt.setInt(1, libro.getIdDocumento());
			if (!libro.getNumeroPaginas().isEmpty()) {
				pstmt.setInt(2, Integer.parseInt(libro.getNumeroPaginas()));
	        } else {
	        	pstmt.setNull(2, java.sql.Types.INTEGER);
	        }
			
			pstmt.setString(3, libro.getIsbn());
			pstmt.executeUpdate();
		}
	}


	public void actualizar(LibroDTO libro) throws SQLException {
	    
	    String sqlLibro = "UPDATE libro SET isbn = ?, numeropaginas = ? WHERE iddocumento = ?";

	    try (Connection conn = ConexionDB.getInstance().getConnection()) {
	        conn.setAutoCommit(false); 

	        try (PreparedStatement pstmt = conn.prepareStatement(sqlLibro)) {

	        	pstmt.setString(1, libro.getIsbn());
	        	if (!libro.getNumeroPaginas().isEmpty()) {
					pstmt.setInt(2, Integer.parseInt(libro.getNumeroPaginas()));
		        } else {
		        	pstmt.setNull(2, java.sql.Types.INTEGER);
		        }
	        	pstmt.setInt(3, libro.getIdDocumento());
	        	pstmt.executeUpdate();

	            conn.commit(); // Confirma los cambios
	        } catch (SQLException e) {
	            conn.rollback(); // Revierte en caso de error
	            throw e;
	        }
	    }
	 }

	public LibroDTO buscarPorId(int id) throws SQLException {
	    String sql = "SELECT isbn, numeropaginas FROM libro WHERE iddocumento = ?";
	    
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return new LibroDTO.BuilderLibro()
	                        .setIsbn(rs.getString("isbn"))
	                        .setNumeroPaginas(rs.getString("numeropaginas"))
	                        .build();
	            }
	        }
	    }
	    return null;
	}


	@Override
	public LibroDTO buscarPorNombre(String nombre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
