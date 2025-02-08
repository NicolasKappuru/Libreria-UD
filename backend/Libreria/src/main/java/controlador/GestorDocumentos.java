package controlador;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import modelo.DocumentoDTO.ArticuloDTO;
import modelo.DocumentoDTO.DocumentoDTO;
import modelo.DocumentoDTO.LibroDTO;
import modelo.DocumentoDTO.PonenciaDTO;
import modelo.persistenciaDAO.DocumentoDAO;

public class GestorDocumentos {
	
	private DocumentoDAO documentoDAO;
	
	
	public GestorDocumentos() {
		documentoDAO = new DocumentoDAO();
	}
	
	public DocumentoDTO construirDocumento(String[] info, String usuario) {
	    String tipo = null;
	    String titulo = null;
	    String fechaPublicacion = null;
	    String mes = null;
	    String dia = null;
	    String autores = null;
	    String editorial = null;
	    String ssn = null;
	    String isbn = null;
	    String numPaginas = null;
	    String nombreCongreso = null;
	    for (String pair : info) {
	        String[] entry = pair.split(":");
	        String key = entry[0].trim();
	        String value = entry[1].trim();
	        switch (key) {
	            case "tipo":  
	            	tipo = value;
	                break;
	            case "titulo":
	            	titulo = value;
	            	break; 
	            case "fechaPublicacion":
	            	fechaPublicacion = value;
	            	LocalDate fecha = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
	            	mes  = String.valueOf(fecha.getMonth());
	            	dia = String.valueOf(fecha.getDayOfMonth());
	                break;
	            case "autores":
	            	autores = value;
	                break;
	            case "editorial":
	            	editorial = value;
	                break;
	            case "isbn":
	            	isbn = value;
	                break;
	            case "numPaginas":
	            	numPaginas = value;
	                break;
	            case "nombreCongreso":
	            	nombreCongreso = value;
	                break;
	            case "ssn":
	            	ssn = value;
	                break;    
	        }
        }
	    
	    if(tipo.equals("libro")) {
	    	LibroDTO.BuilderLibro libro = new LibroDTO.BuilderLibro();
	    	return libro.setIsbn(isbn)
	    	.setNumeroPaginas(numPaginas)
	    	.setTitulo(titulo)
	    	.setTipo(tipo)
	    	.setFechaPublicacion(fechaPublicacion)
	    	.setMesPublicacion(mes)
	    	.setDiaPublicacion(dia)
	    	.setAutores(autores)
	    	.setEditorial(editorial)
	    	.setPropietario(usuario)
	    	.build();
	    	
	    	
	    }else if(tipo.equals("ponencia")){
	    	PonenciaDTO.BuilderPonencia ponencia = new PonenciaDTO.BuilderPonencia();
	    	return ponencia.setIsbn(isbn)
	    	.setCongreso(nombreCongreso)
	    	.setTitulo(titulo)
	    	.setTipo(tipo)
	    	.setFechaPublicacion(fechaPublicacion)
	    	.setMesPublicacion(mes)
	    	.setDiaPublicacion(dia)
	    	.setAutores(autores)
	    	.setEditorial(editorial)
	    	.setPropietario(usuario)
	    	.build();
	    	
	    }else {
	    	ArticuloDTO.BuilderArticulo articulo = new ArticuloDTO.BuilderArticulo();
	    	return articulo.setSsn(ssn)
	    	.setTitulo(titulo)
	    	.setTipo(tipo)
	    	.setFechaPublicacion(fechaPublicacion)
	    	.setMesPublicacion(mes)
	    	.setDiaPublicacion(dia)
	    	.setAutores(autores)
	    	.setEditorial(editorial)
	    	.setPropietario(usuario)
	    	.build();
	    }
	}
	
	public String crearDocumento(String[] info, String usuario) {
		DocumentoDTO documento = construirDocumento(info, usuario);
		try{
			return "{\"id\": \"" + documentoDAO.crear(documento) + "\"}";
		}catch (SQLException e) {
			return "{\"mensaje\": \"Error: " +e+"\"}";
		}
	}
}
