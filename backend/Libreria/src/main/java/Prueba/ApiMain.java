package Prueba;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import modelo.DocumentoDTO.PonenciaDTO;

import java.sql.SQLException;

import modelo.DocumentoDTO.ArticuloDTO;
import modelo.DocumentoDTO.DocumentoDTO;
import modelo.DocumentoDTO.LibroDTO;
import modelo.persistencia.UsuarioDAO;
import modelo.persistencia.UsuarioDTO;
import modelo.persistenciaDAO.ArticuloDAO;
import modelo.persistenciaDAO.DocumentoDAO;
import modelo.persistenciaDAO.LibroDAO;
import modelo.persistenciaDAO.PonenciaDAO;

public class ApiMain {

	public static void main(String[] args) throws SQLException {

		//Prueba metodos de usuario
		UsuarioDAO dao = new UsuarioDAO(); 
		UsuarioDTO user = dao.buscarPorNombre("Nicolas");
		System.out.println(user.toString());
		UsuarioDTO user2 = dao.buscarPorId(15); 
		System.out.println(user2.toString());
		
		//Prueba metodos de documento
		DocumentoDAO dao3 = new DocumentoDAO(); 
		DocumentoDTO doc1 = dao3.buscarPorId(4);
		System.out.println(doc1.toString());
		
		//Prueba libro
		LibroDAO dao4 = new LibroDAO(); 
		LibroDTO doc2 = dao4.buscarPorId(1);
		System.out.println(doc2.toString());
		
		//Prueba articulo
		ArticuloDAO dao5 = new ArticuloDAO(); 
		ArticuloDTO doc3 = dao5.buscarPorId(1);
		System.out.println(doc3.toString());
		
		//Prueba ponencia
		PonenciaDAO dao6 = new PonenciaDAO(); 
		PonenciaDTO doc4 = dao6.buscarPorId(1);
		System.out.println(doc4.toString());
		
		ArticuloDTO articulo = new ArticuloDTO.BuilderArticulo()
				.setIdDocumento(4)
				.setAutores("Nikokado - Hendich")
				.setDiaPublicacion("Lunes")
				.setEditorial("Colimun")
				.setEstado("En reserva")
				.setFechaPublicacion("2/2/2023")
				.setMesPublicacion("Marzo")
				.setTitulo("Cientist things")
				.setPropietario("11")
				.setSsn("A12345")
				.setIdArticulo(1)
				.build(); 
		
		dao5.actualizar(articulo);
		System.out.println(articulo.toString());
		
		/*
		documento = new DocumentoDTO.BuilderDoc()
				.setIdDocumento(12)
				.setAutores("Fantastico Señor zorro")
				.setDiaPublicacion("Martes")
				.setEditorial("Colimu12n")
				.setEstado("En Comision")
				.setFechaPublicacion("2/2/2023")
				.setMesPublicacion("Junio")
				.setTitulo("Mr and Mss fox")
				.build();
		*/
		/*
		UsuarioDTO usuario = new UsuarioDTO.Builder()
				.setNombre("Henry Jhonmarcos")
				.setNumeroTelefonico("3453523")
				.setDireccionFisica("Calle 150")
				.setCorreoElectronico("hent23ysd@asds")
				.setContrasena("Mkasdi")
				.setId(15) //Pilas, el id debe coincidir en la BD
				.build();
	
		UsuarioDAO dao = new UsuarioDAO(); 
		dao.actualizar(usuario);
	
		
		DocumentoDTO documento = new DocumentoDTO.BuilderDoc()
				.setIdDocumento(12)
				.setAutores("Nikokado - Hendich")
				.setDiaPublicacion("Lunes")
				.setEditorial("Colimun")
				.setEstado("En reserva")
				.setFechaPublicacion("2/2/2023")
				.setMesPublicacion("Marzo")
				.setTitulo("LulYeah")
				.build(); 
		
		DocumentoDAO dao2 = new DocumentoDAO();
		dao2.crear(documento); 
	*/
	/*
		PonenciaDTO ponencia = new PonenciaDTO.BuilderPonencia()
				.setIdDocumento(12)
				.setAutores("Nikokado - Hendich")
				.setDiaPublicacion("Lunes")
				.setEditorial("Colimun")
				.setEstado("En reserva")
				.setFechaPublicacion("2/2/2023")
				.setMesPublicacion("Marzo")
				.setTitulo("LulYeah")
				.setIsbn("asdasdsd")
				.setCongreso("De la repiblica")
				.setIdDocumento(0)
				.build(); 
		
		PonenciaDAO dao3 = new PonenciaDAO();
		dao3.crear(ponencia);
	*/
	/*	ArticuloDTO articulo = new ArticuloDTO.BuilderArticulo()
				.setIdDocumento(12)
				.setAutores("Nikokado - Hendich")
				.setDiaPublicacion("Lunes")
				.setEditorial("Colimun")
				.setEstado("En reserva")
				.setFechaPublicacion("2/2/2023")
				.setMesPublicacion("Marzo")
				.setTitulo("LulYeah")
				.setSsn("a125215")
				.build(); 
		
		ArticuloDAO dao4 = new ArticuloDAO();
		dao4.crear(articulo);	
		*/
		/*
		LibroDTO libro = new LibroDTO.BuilderLibro()
				.setIdDocumento(12)
				.setAutores("Nikokado - Hendich")
				.setDiaPublicacion("Lunes")
				.setEditorial("Colimun")
				.setEstado("En reserva")
				.setFechaPublicacion("2/2/2023")
				.setMesPublicacion("Marzo")
				.setTitulo("LulYeah")
				.setNumeroPaginas("12")
				.setIsbn("asdas")
				.build(); 
		
		LibroDAO dao5 = new LibroDAO();
		dao5.crear(libro);
		*/
	} 
}
