package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import modelo.Documento;
import modelo.DocumentoDTO.ArticuloDTO;
import modelo.DocumentoDTO.DocumentoDTO;
import modelo.DocumentoDTO.DocumentoFactory;
import modelo.DocumentoDTO.LibroDTO;
import modelo.DocumentoDTO.PonenciaDTO;
import modelo.FactoryDAO.FabricaDAO;
import modelo.OtrosDTO.EventoDTO;
import modelo.persistenciaDAO.ArticuloDAO;
import modelo.persistenciaDAO.DocumentoDAO;
import modelo.persistenciaDAO.EventoDAO;
import modelo.persistenciaDAO.LibroDAO;
import modelo.persistenciaDAO.PonenciaDAO;

public class GestorDocumentos {
	
	private DocumentoDAO documentoDAO;
	private ObjectMapper objectMapper;
	private FabricaDAO fabrica;
	private EventoDAO eventoDAO;
	
	public GestorDocumentos() {
		documentoDAO = new DocumentoDAO();
		fabrica = new FabricaDAO();
		eventoDAO = new EventoDAO();
		objectMapper = new ObjectMapper();
	}
	
	public DocumentoDTO.BuilderDoc construirBuilder(Documento documento, String usuario){
		String mes = "";
		String dia = "";
		if (!documento.getFechaPublicacion().isEmpty()) {
		    LocalDate fecha = LocalDate.parse(documento.getFechaPublicacion(), DateTimeFormatter.ISO_LOCAL_DATE);
		    Locale spanishLocale = Locale.of("es", "ES");
		    mes = fecha.getMonth().getDisplayName(TextStyle.FULL, spanishLocale);
		    dia = String.valueOf(fecha.getDayOfMonth());
		}

		return DocumentoFactory.getBuilder(documento.getTipo())
        	    .setTitulo(documento.getTitulo())
        	    .setFechaPublicacion(documento.getFechaPublicacion())
        	    .setAutores(documento.getAutores())
        	    .setEditorial(documento.getEditorial())
        	    .setEstado("Disponible")
        	    .setTipo(documento.getTipo())
        	    .setPropietario(usuario)
        	    .setMesPublicacion(mes)
        	    .setDiaPublicacion(dia)
        	    .setIdDocumento(documento.getIddocumento());
	}
	
	public ArticuloDTO crearArticulo(DocumentoDTO.BuilderDoc builder, Documento documento) {
		return ((ArticuloDTO.BuilderArticulo) builder)
				.setSsn(documento.getSsn())
				.setIdDocumento(documento.getIddocumento())
				.build();
	}
	
	public LibroDTO crearLibro(DocumentoDTO.BuilderDoc builder, Documento documento) {
		return ((LibroDTO.BuilderLibro) builder)
				.setNumeroPaginas(documento.getNumPaginas())
				.setIsbn(documento.getIsbn())
				.setIdDocumento(documento.getIddocumento())
				.build();
	}
	
	public PonenciaDTO crearPonencia(DocumentoDTO.BuilderDoc builder, Documento documento) {
		return ((PonenciaDTO.BuilderPonencia) builder)
				.setCongreso(documento.getNombreCongreso())
				.setIsbn(documento.getIsbn())
				.setIdDocumento(documento.getIddocumento())
				.build();
	}
	
	public String crearDocumento(HttpServletRequest request, String usuario) throws JsonProcessingException {
		
		try {
			Documento documento = objectMapper.readValue(request.getReader(), Documento.class);
			
			DocumentoDTO.BuilderDoc builder = construirBuilder(documento, usuario);
			
			int iddocumento = documentoDAO.crear(builder.build());
			documento.setIddocumento(iddocumento);
			
			if(builder instanceof ArticuloDTO.BuilderArticulo) {
				ArticuloDTO articulo = crearArticulo(builder, documento);
				ArticuloDAO dao = fabrica.crearArticulo();
				dao.crear(articulo);
			}else if(builder instanceof LibroDTO.BuilderLibro) {
				LibroDTO libro = crearLibro(builder, documento);
				LibroDAO dao = fabrica.crearLibro();
				dao.crear(libro);
			}else if(builder instanceof PonenciaDTO.BuilderPonencia) {
				PonenciaDTO ponencia = crearPonencia(builder, documento);
				PonenciaDAO dao = fabrica.crearPonencia();
				dao.crear(ponencia);
			}
			LocalDate fechaActual = LocalDate.now();

	        String fechaFormateada = fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			EventoDTO evento = new EventoDTO.BuilderEvento()
					.setTipoEvento("Creado")
					.setUsuario(usuario)
					.setDocumento(iddocumento)
					.setFecha(fechaFormateada)
					.build();
			
			eventoDAO.crear(evento);
            return "{\"mensaje\": \""+iddocumento+"\"}";
            
        } catch (IOException e) {
        	Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Error al leer JSON: " + e.getMessage());
            return objectMapper.writeValueAsString(errorResponse);
        } catch (SQLException e) {
        	Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Error en la base de datos: " + e.getMessage());

            return objectMapper.writeValueAsString(errorResponse);
        }
		
	}
	
	public String modificarDocumento(HttpServletRequest request, String usuario) throws JsonProcessingException {
		
		try {
			Documento documento = objectMapper.readValue(request.getReader(), Documento.class);
			
			DocumentoDTO.BuilderDoc builder = construirBuilder(documento, usuario);
			
			documentoDAO.actualizar(builder.build());
			
			if(builder instanceof ArticuloDTO.BuilderArticulo) {
				ArticuloDTO articulo = crearArticulo(builder, documento);
				ArticuloDAO dao = fabrica.crearArticulo();
				dao.actualizar(articulo);
			}else if(builder instanceof LibroDTO.BuilderLibro) {
				LibroDTO libro = crearLibro(builder, documento);
				LibroDAO dao = fabrica.crearLibro();
				dao.actualizar(libro);
			}else if(builder instanceof PonenciaDTO.BuilderPonencia) {
				PonenciaDTO ponencia = crearPonencia(builder, documento);
				PonenciaDAO dao = fabrica.crearPonencia();
				dao.actualizar(ponencia);
			}
			LocalDate fechaActual = LocalDate.now();

	        String fechaFormateada = fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			EventoDTO evento = new EventoDTO.BuilderEvento()
					.setTipoEvento("Modificado")
					.setUsuario(usuario)
					.setDocumento(documento.getIddocumento())
					.setFecha(fechaFormateada)
					.build();
			
			eventoDAO.crear(evento);
            return "{\"mensaje\": \"Actualizado\"}";
            
        } catch (IOException e) {
        	Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Error al leer JSON: " + e.getMessage());
            return objectMapper.writeValueAsString(errorResponse);
        } catch (SQLException e) {
        	Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Error en la base de datos: " + e.getMessage());

            return objectMapper.writeValueAsString(errorResponse);
        }
	}

	public String modificarEstado(int iddocumento, String estado, String usuario) throws JsonProcessingException{
		try {
			
			String estadoDoc = estado;
			if(estado.equals("Entregado") || estado.equals("Habilito")) {
				estadoDoc = "Disponible";
			}
			DocumentoDTO documento = new DocumentoDTO.BuilderDoc().setEstado(estadoDoc).setIdDocumento(iddocumento).build();
			
			documentoDAO.actualizarEstado(documento);
			
			LocalDate fechaActual = LocalDate.now();
	        String fechaFormateada = fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			EventoDTO evento = new EventoDTO.BuilderEvento()
					.setTipoEvento(estado)
					.setUsuario(usuario)
					.setDocumento(documento.getIdDocumento())
					.setFecha(fechaFormateada)
					.build();
			
			eventoDAO.crear(evento);
            return "{\"mensaje\": \"Actualizado\"}";
            
        } catch (SQLException e) {
        	Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Error en la base de datos: " + e.getMessage());

            return objectMapper.writeValueAsString(errorResponse);
        }
	}
	
	public String eliminarDocumento(HttpServletRequest request, String usuario) throws JsonProcessingException {
		try {
			
			Documento documento = objectMapper.readValue(request.getReader(), Documento.class);
            return modificarEstado(documento.getIddocumento(), "Eliminado", usuario);
            
        } catch (IOException e) {
        	Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Error al leer JSON: " + e.getMessage());
            return objectMapper.writeValueAsString(errorResponse);
        }
	}
	
	public String habilitarDocumento(HttpServletRequest request, String usuario) throws JsonProcessingException {
		try {
			
			Documento documento = objectMapper.readValue(request.getReader(), Documento.class);
            return modificarEstado(documento.getIddocumento(), "Habilito", usuario);
            
        } catch (IOException e) {
        	Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Error al leer JSON: " + e.getMessage());
            return objectMapper.writeValueAsString(errorResponse);
        }
	}
}
