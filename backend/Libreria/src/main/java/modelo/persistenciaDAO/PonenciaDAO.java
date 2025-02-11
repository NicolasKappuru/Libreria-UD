package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.DocumentoDTO.PonenciaDTO;
import modelo.persistencia.ConexionDB;

public class PonenciaDAO implements DAO<PonenciaDTO>{

	@Override
	public void crear(PonenciaDTO ponencia) throws SQLException {
		String sql = "INSERT INTO ponencia (iddocumento, congreso, isbn) VALUES (?, ?, ?)";
		try(Connection conexion = ConexionDB.getInstance().getConnection();
			PreparedStatement pstmt = conexion.prepareStatement(sql)){
			pstmt.setInt(1, ponencia.getIdDocumento());
			pstmt.setString(2, ponencia.getCongreso());
			pstmt.setString(3, ponencia.getIsbn());
			pstmt.executeUpdate();
			
		}
	}

	@Override
	public PonenciaDTO buscarPorNombre(String nombre) throws SQLException {
		// Aqui va la logica para ponencias
		return null;
	}

	@Override
	public void eliminarPorID(int id) throws SQLException {
	    String sqlPonencia = "DELETE FROM ponencia WHERE idponencia = ?";
	    String sqlDocumento = "DELETE FROM documento WHERE iddocumento = " +
	                          "(SELECT documento FROM ponencia WHERE idponencia = ?)";

	    try (Connection conn = ConexionDB.getInstance().getConnection()) {
	        conn.setAutoCommit(false);

	        try (PreparedStatement pstmtDocumento = conn.prepareStatement(sqlDocumento);
	             PreparedStatement pstmtPonencia = conn.prepareStatement(sqlPonencia)) {
	            
	            pstmtDocumento.setInt(1, id);
	            pstmtDocumento.executeUpdate();

	            pstmtPonencia.setInt(1, id);
	            pstmtPonencia.executeUpdate();
	            
	            conn.commit();
	        } catch (SQLException e) {
	            conn.rollback();
	            throw e;
	        }
	    }
	}


	@Override
	public void actualizar(PonenciaDTO ponencia) throws SQLException {
	  
	    String sqlPonencia = "UPDATE ponencia SET congreso = ?, isbn = ? WHERE iddocumento = ?";

	    try (Connection conn = ConexionDB.getInstance().getConnection()) {
	        conn.setAutoCommit(false); 

	        try (PreparedStatement pstmt = conn.prepareStatement(sqlPonencia)) {
	            
	        	pstmt.setString(1, ponencia.getCongreso());
	            pstmt.setString(2, ponencia.getIsbn());
	            pstmt.setInt(3, ponencia.getIdDocumento());
	            pstmt.executeUpdate();
	        
	            conn.commit();
	        } catch (SQLException e) {
	            conn.rollback(); // Revierte en caso de error
	            throw e;
	        }
	    }
	}

	  public static Date convertirStringADate(String fechaStr) {
	        try {
	            SimpleDateFormat formato = new SimpleDateFormat("d/M/yyyy"); // Define el formato esperado
	            java.util.Date fechaUtil = formato.parse(fechaStr); // Convierte a java.util.Date
	            return new java.sql.Date(fechaUtil.getTime()); // Convierte a java.sql.Date
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null; // Manejo de error: Devuelve null si hay un fallo
	        }
	    }

	@Override
	public PonenciaDTO buscarPorId(int id) throws SQLException {
	    String sql = "SELECT congreso, isbn FROM ponencia WHERE iddocumento = ?";
	    
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return new PonenciaDTO.BuilderPonencia()
	                        .setCongreso(rs.getString("congreso"))
	                        .setIsbn(rs.getString("isbn"))
	                        .build();
	            }
	        }
	    }
	    return null;
	}


}
