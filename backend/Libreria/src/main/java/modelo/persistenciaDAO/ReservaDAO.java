package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.OtrosDTO.ReservaDTO;
import modelo.persistencia.ConexionDB;

public class ReservaDAO{

	public void crear(ReservaDTO reserva)throws SQLException{
		String sql = "INSERT INTO reserva (fechareserva, estado, documento, usuario) VALUES (?, ?, ?, ?)";

	    try (Connection conexion = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conexion.prepareStatement(sql)) {
	    	
	    	pstmt.setDate(1, java.sql.Date.valueOf(reserva.getFechaReserva()));
	        pstmt.setString(2, reserva.getEstado());
	        pstmt.setInt(3, reserva.getDocumento());
	        pstmt.setString(4, reserva.getUsuario());
	     
	        pstmt.executeUpdate();
	    }
		
	}
	
	public int actualizar(ReservaDTO reserva)throws SQLException{
		String sql = "UPDATE reserva SET estado = ?, fechaentrega = ? WHERE idreserva = ? RETURNING documento";

	    try (Connection conexion = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conexion.prepareStatement(sql)) {
	    	
	    	pstmt.setString(1, reserva.getEstado());
	    	pstmt.setDate(2, java.sql.Date.valueOf(reserva.getFechaEntrega()));
	        pstmt.setInt(3, reserva.getIdReserva());
	     
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1); 
	            } else {
	                throw new SQLException("No se pudo obtener el ID generado.");
	            }
	        }
	    }
	}
}
