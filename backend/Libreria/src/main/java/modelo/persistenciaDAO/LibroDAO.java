package modelo.persistenciaDAO;

import java.sql.SQLException;

import modelo.DocumentoDTO.LibroDTO;

public class LibroDAO implements DAO<LibroDTO>{

	@Override
	public void crear(LibroDTO DTO) throws SQLException{
		// Aqui va la logica para Libros
		
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
