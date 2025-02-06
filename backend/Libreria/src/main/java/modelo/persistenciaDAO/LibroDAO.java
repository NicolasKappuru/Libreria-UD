package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.DocumentoDTO.ArticuloDTO;
import modelo.DocumentoDTO.LibroDTO;
import modelo.persistencia.ConexionDB;

public class LibroDAO implements DAO<LibroDTO>{

	@Override
	public void crear(LibroDTO libro) throws SQLException {
		String sql = "INSERT INTO libro (numeropaginas, isbn, documento) VALUES (?, ?, ?)";
		try(Connection conexion = ConexionDB.getInstance().getConnection();
			PreparedStatement pstmt = conexion.prepareStatement(sql)){
			pstmt.setInt(1, Integer.parseInt(libro.getNumeroPaginas()));
			pstmt.setString(2, libro.getIsbn());
			pstmt.setInt(3, 4);
			pstmt.executeUpdate();
		}
	}
	

	@Override
	public LibroDTO buscarPorNombre(String nombre) throws SQLException{
		// Aqui va la logica para Libros
		return null;
	}

	@Override
	public void eliminarPorID(int id) {
		// Aqui va la logica para Libros
	}

	@Override
	public void actualizar(LibroDTO DTO) {
		// Aqui va la logica para Libros
	}

}
