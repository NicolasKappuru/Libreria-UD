package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.DocumentoDTO.ArticuloDTO;
import modelo.DocumentoDTO.PonenciaDTO;
import modelo.persistencia.ConexionDB;

public class ArticuloDAO implements DAO<ArticuloDTO>{

	@Override
	public void crear(ArticuloDTO articulo) throws SQLException {
		String sql = "INSERT INTO articulo (ssn, documento) VALUES (?, ?)";
		try(Connection conexion = ConexionDB.getInstance().getConnection();
			PreparedStatement pstmt = conexion.prepareStatement(sql)){
			pstmt.setString(1, articulo.getSsn());
			pstmt.setInt(2, 4);
			pstmt.executeUpdate();
		}
	}

	@Override
	public ArticuloDTO buscarPorNombre(String nombre) throws SQLException{
		//Aqui ponemos la logica
		return null;
	}

	@Override
	public void eliminarPorID(int id) {
		//Aqui ponemos la logica
	}

	@Override
	public void actualizar(ArticuloDTO DTO) {
		//Aqui ponemos la logica
	}

}
