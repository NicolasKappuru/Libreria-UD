package modelo.DocumentoDTO;

import java.io.Serializable;

public class ArticuloDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Los atributos correspondientes de un articulo cientifico
	private int idArticulo;
	private String congreso; 
	private String SSN; 
	
	//Los atribuots comunes de documento
	private int idDocumento; 
	private String titulo; 
	private String fechaPublicacion; 
	private String autores; 
	private String mesPublicacion; 
	private String diaPublicacion; 
	private String editorial; 
	private String estado; 
	private String propietario; 
	
	public ArticuloDTO() {		
	}
	
}