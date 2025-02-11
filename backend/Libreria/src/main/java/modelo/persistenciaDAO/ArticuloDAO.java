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

	public ArticuloDTO buscarPorId(int id) throws SQLException {
	    String sql = "SELECT ssn FROM articulo WHERE iddocumento = ?";
	    
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return new ArticuloDTO.BuilderArticulo()
	                        .setSsn(rs.getString("ssn"))
	                        .build();
	            }
	        }
	    }
	    return null;
	}


}
