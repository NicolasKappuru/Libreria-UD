package modelo.FactoryDAO;

import modelo.persistenciaDAO.ArticuloDAO;
import modelo.persistenciaDAO.LibroDAO;
import modelo.persistenciaDAO.PonenciaDAO;

public class FabricaDAO implements DAOFactory{

	@Override
	public ArticuloDAO crearArticulo() {
		ArticuloDAO articuloDAO = new ArticuloDAO(); 
		return articuloDAO;
	}

	@Override
	public LibroDAO crearLibro() {
		LibroDAO libroDAO = new LibroDAO(); 
		return libroDAO;
	}

	@Override
	public PonenciaDAO crearPonencia() {
		PonenciaDAO ponenciaDAO = new PonenciaDAO(); 
		return ponenciaDAO;
	}

}
