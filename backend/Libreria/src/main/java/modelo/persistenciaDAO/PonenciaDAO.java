package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.DocumentoDTO.PonenciaDTO;
import modelo.persistencia.ConexionDB;

public class PonenciaDAO implements DAO<PonenciaDTO>{

	@Override
	public void crear(PonenciaDTO ponencia) throws SQLException {
		String sql = "INSERT INTO ponencia (congreso, isbn, documento) VALUES (?, ?, ?)";
		try(Connection conexion = ConexionDB.getInstance().getConnection();
			PreparedStatement pstmt = conexion.prepareStatement(sql)){
			pstmt.setString(1, ponencia.getCongreso());
			pstmt.setString(2, ponencia.getIsbn());
			pstmt.setInt(3, 4);
			pstmt.executeUpdate();
			
		}
	}

	@Override
	public PonenciaDTO buscarPorNombre(String nombre) throws SQLException {
		// Aqui va la logica para ponencias
		return null;
	}

	@Override
	public void eliminarPorID(int id) {
		// Aqui va la logica para ponencias
		
	}

	@Override
	public void actualizar(PonenciaDTO DTO) {
		// Aqui va la logica para ponencias
		
	}

}
