package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.OtrosDTO.EventoDTO;
import modelo.persistencia.ConexionDB;

public class EventoDAO implements DAO<EventoDTO>{

	@Override
	public void crear(EventoDTO evento) throws SQLException {
		String sql = "INSERT INTO evento (tipoevento, usuario, documento, evento) VALUES (?, ?, ?, ?)";

	    try (Connection conexion = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conexion.prepareStatement(sql)) {

	        pstmt.setString(1, evento.getTipoEvento());
	        pstmt.setString(2, evento.getUsuario());
	        pstmt.setInt(3, evento.getDocumento());
	        if (!evento.getFecha().isEmpty()) {
	            pstmt.setDate(4, java.sql.Date.valueOf(evento.getFecha()));
	        } else {
	            pstmt.setNull(4, java.sql.Types.DATE);
	        }
	        pstmt.executeUpdate();
	    }
		
	}

	@Override
	public EventoDTO buscarPorNombre(String nombre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPorID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(EventoDTO DTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EventoDTO buscarPorId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
