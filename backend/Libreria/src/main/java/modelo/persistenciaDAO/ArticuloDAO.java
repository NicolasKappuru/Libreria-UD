package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.DocumentoDTO.ArticuloDTO;
import modelo.persistencia.ConexionDB;

public class ArticuloDAO implements DAO<ArticuloDTO>{

	
	public void crear(ArticuloDTO articulo) throws SQLException {
		String sql = "INSERT INTO articulo (iddocumento, ssn) VALUES (?, ?)";
		try(Connection conexion = ConexionDB.getInstance().getConnection();
			PreparedStatement pstmt = conexion.prepareStatement(sql)){
			pstmt.setInt(1, articulo.getIdDocumento());
			pstmt.setString(2, articulo.getSsn());
			pstmt.executeUpdate();
		}
	}

	
	public ArticuloDTO buscarPorNombre(String nombre) throws SQLException{
		//Aqui ponemos la logica
		return null;
	}

	
	public void eliminarPorID(int id) throws SQLException {
	    String sqlArticulo = "DELETE FROM articulo WHERE idarticulo = ?";
	    String sqlDocumento = "DELETE FROM documento WHERE iddocumento = " +
	                          "(SELECT documento FROM articulo WHERE idarticulo = ?)";

	    try (Connection conn = ConexionDB.getInstance().getConnection()) {
	        conn.setAutoCommit(false);

	        try (PreparedStatement pstmtDocumento = conn.prepareStatement(sqlDocumento);
	             PreparedStatement pstmtArticulo = conn.prepareStatement(sqlArticulo)) {
	            
	            pstmtDocumento.setInt(1, id);
	            pstmtDocumento.executeUpdate();

	            pstmtArticulo.setInt(1, id);
	            pstmtArticulo.executeUpdate();
	            
	            conn.commit();
	        } catch (SQLException e) {
	            conn.rollback();
	            throw e;
	        }
	    }
	}


	
	public void actualizar(ArticuloDTO articulo) throws SQLException {	    
	    String sqlArticulo = "UPDATE articulo SET ssn = ? WHERE iddocumento = ?";

	    try (Connection conn = ConexionDB.getInstance().getConnection()) {
	        conn.setAutoCommit(false);

	        try (PreparedStatement pstmt = conn.prepareStatement(sqlArticulo)) {

	        	pstmt.setString(1, articulo.getSsn());
	        	pstmt.setInt(2, articulo.getIdDocumento());
	        	pstmt.executeUpdate();

	            conn.commit(); // Confirma los cambios
	        } catch (SQLException e) {
	            conn.rollback(); // Revierte la transacción en caso de error
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

	public ArticuloDTO buscarPorId(int id) throws SQLException {
	    String sql = "SELECT a.idarticulo, a.ssn, " +
	                 "d.iddocumento, d.titulo, d.fechapublicacion, d.autores, " +
	                 "d.mespublicacion, d.diapublicacion, d.editorial, d.estado, d.propietario " +
	                 "FROM articulo a " +
	                 "JOIN documento d ON a.documento = d.iddocumento " +
	                 "WHERE a.idarticulo = ?";
	    
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                System.out.println(rs.getString("titulo"));
	                return new ArticuloDTO.BuilderArticulo()
	                        .setSsn(rs.getString("ssn"))
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
