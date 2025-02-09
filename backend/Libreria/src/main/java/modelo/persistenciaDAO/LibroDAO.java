package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	

	public LibroDTO buscarPorNombre(String nombre) throws SQLException{
		// Aqui va la logica para Libros
		return null;
	}

	public void eliminarPorID(int id) throws SQLException {
	    String sqlLibro = "DELETE FROM libro WHERE idlibro = ?";
	    String sqlDocumento = "DELETE FROM documento WHERE iddocumento = " +
	                          "(SELECT documento FROM libro WHERE idlibro = ?)";

	    try (Connection conn = ConexionDB.getInstance().getConnection()) {
	        conn.setAutoCommit(false);

	        try (PreparedStatement pstmtDocumento = conn.prepareStatement(sqlDocumento);
	             PreparedStatement pstmtLibro = conn.prepareStatement(sqlLibro)) {
	            
	            pstmtDocumento.setInt(1, id);
	            pstmtDocumento.executeUpdate();

	            pstmtLibro.setInt(1, id);
	            pstmtLibro.executeUpdate();
	            
	            conn.commit();
	        } catch (SQLException e) {
	            conn.rollback();
	            throw e;
	        }
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

	public LibroDTO buscarPorId(int id) throws SQLException {
	    String sql = "SELECT l.idlibro, l.isbn, l.numeropaginas, " +
	                 "d.iddocumento, d.titulo, d.fechapublicacion, d.autores, " +
	                 "d.mespublicacion, d.diapublicacion, d.editorial, d.estado, d.propietario " +
	                 "FROM libro l " +
	                 "JOIN documento d ON l.documento = d.iddocumento " +
	                 "WHERE l.idlibro = ?";
	    
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                System.out.println(rs.getString("titulo"));
	                return new LibroDTO.BuilderLibro()
	                        .setIsbn(rs.getString("isbn"))
	                        .setNumeroPaginas(rs.getString("numeropaginas"))
	                        .setIdDocumento(rs.getInt("iddocumento"))  // Datos de documento heredados
	                        .setTitulo(rs.getString("titulo"))
	                        .setFechaPublicacion(rs.getString("fechapublicacion"))
	                        .setAutores(rs.getString("autores"))
	                        .setMesPublicacion(rs.getString("mespublicacion"))
	                        .setDiaPublicacion(rs.getString("diapublicacion"))
	                        .setEditorial(rs.getString("editorial"))
	                        .setEstado(rs.getString("estado"))
	                        .setPropietario(rs.getString("propietario"))
	                        .build();
	            }
	        }
	    }
	    return null;
	}



}
