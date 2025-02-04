package modelo.FactoryDAO;

import modelo.persistenciaDAO.ArticuloDAO;
import modelo.persistenciaDAO.LibroDAO;
import modelo.persistenciaDAO.PonenciaDAO;

public interface DAOFactory {

	ArticuloDAO crearArticulo();
	LibroDAO crearLibro(); 
	PonenciaDAO crearPonencia(); 
}
