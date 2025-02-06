package modelo.persistenciaDAO;

import java.sql.SQLException;

import modelo.DocumentoDTO.ArticuloDTO;

public class ArticuloDAO implements DAO<ArticuloDTO>{

	@Override
	public void crear(ArticuloDTO DTO) throws SQLException{
		//Aqui ponemos la logica
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
