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
	
	public String consultarReservas(String usuario) throws SQLException {
	    String sql = "SELECT r.idreserva, d.titulo, d.tipo, r.fechareserva, r.fechaentrega, r.estado " +
	                 "FROM documento d JOIN reserva r ON d.iddocumento = r.documento WHERE usuario = ?";

	    StringBuilder json = new StringBuilder();
	    json.append("[");

	    try (Connection conexion = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conexion.prepareStatement(sql)) {

	        pstmt.setString(1, usuario);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            boolean first = true;
	            while (rs.next()) {
	                if (!first) {
	                    json.append(",");
	                }
	                first = false;

	                json.append("{")
	                    .append("\"idreserva\":").append(rs.getInt("idreserva")).append(",")
	                    .append("\"titulo\":\"").append(rs.getString("titulo")).append("\",")
	                    .append("\"tipo\":\"").append(rs.getString("tipo")).append("\",")
	                    .append("\"fechareserva\":\"").append(rs.getDate("fechareserva")).append("\",")
	                    .append("\"fechaentrega\":\"").append(rs.getDate("fechaentrega")).append("\",")
	                    .append("\"estado\":\"").append(rs.getString("estado")).append("\"")
	                    .append("}");
	            }
	        }
	    }

	    json.append("]");
	    return json.toString();
	}

}
