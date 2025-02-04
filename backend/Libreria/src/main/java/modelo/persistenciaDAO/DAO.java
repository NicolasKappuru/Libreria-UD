package modelo.persistenciaDAO;

import java.sql.SQLException;

import modelo.persistencia.UsuarioDTO;

public interface DAO<T>{ //La haremos genereica, pues puede tener diferentes DTO
	void crear(T DTO) throws SQLException;
	T buscarPorNombre(String nombre) throws SQLException; 
	void eliminarPorID(int id); 
	void actualizar(T DTO);
}
