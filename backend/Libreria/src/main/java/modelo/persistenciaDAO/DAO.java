package modelo.persistenciaDAO;

public interface DAO<T>{ //La haremos genereica, pues puede tener diferentes DTO
	void crear(T DTO);
	T buscarPorNombre(); 
}
