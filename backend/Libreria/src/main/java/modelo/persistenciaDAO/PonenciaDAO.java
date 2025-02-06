package modelo.persistenciaDAO;

import java.sql.SQLException;

import modelo.DocumentoDTO.PonenciaDTO;

public class PonenciaDAO implements DAO<PonenciaDTO>{

	@Override
	public void crear(PonenciaDTO DTO) throws SQLException {
		// Aqui va la logica para ponencias
		
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
