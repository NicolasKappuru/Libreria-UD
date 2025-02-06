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

		/*
		LibroDTO libro = new LibroDTO.BuilderLibro()
                .setIdDocumento(15)
                .setTitulo("El Arte de la Programación")
                .setFechaPublicacion("2025-02-02")
                .setDiaPublicacion("Lunes")
                .setEditorial("Addison-Wesley")
                .setEstado("Publicado")
                .setPropietario("Donald Knuth")
                .setIsbn("978-0321751041")
                .build();
		System.out.println(libro.toString());

		PonenciaDTO ponencia = new PonenciaDTO.BuilderPonencia()
                .setIdDocumento(17)
                .setTitulo("Instituto demanda")
                .setFechaPublicacion("2025-10-05")
                .setDiaPublicacion("Lunes")
                .setEditorial("Addison-Wesley")
                .setEstado("Publicado")
                .setPropietario("Donald Knuth")
                .setIdPonencia(13)
                .setIsbn("12908UIOI22")
                .setCongreso("Vaticano")
                .build();
		System.out.println(ponencia.toString());
		
		ArticuloDTO articulo = new ArticuloDTO.BuilderArticulo()
                .setIdDocumento(16)
                .setTitulo("Descubrimiento sobre IA")
                .setFechaPublicacion("2025-08-14")
                .setDiaPublicacion("Lunes")
                .setEditorial("Addison-Wesley")
                .setEstado("Publicado")
                .setPropietario("Donald Knuth")
                .setIdArticulo(19)
                .setSsn("1000012002")
                .build();
		System.out.println(articulo.toString());
	*/
		/*
		UsuarioDTO usuario = new UsuarioDTO.Builder()
				.setNombre("Nicolas")
				.setNumeroTelefonico("124124")
				.setId(12)
				.setDireccionFisica("Carrera 123")
				.setCorreoElectronico("nicasd@asds")
				.setContrasena("Mawile")
				.build();
	
		UsuarioDAO dao = new UsuarioDAO(); 
		dao.crear(usuario);
		*/
		/*
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
	} 
}
