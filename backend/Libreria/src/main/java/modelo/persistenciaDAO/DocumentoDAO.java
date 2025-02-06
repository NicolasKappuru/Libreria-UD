package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.DocumentoDTO.DocumentoDTO;
import modelo.persistencia.ConexionDB;

public class DocumentoDAO implements DAO<DocumentoDTO>{

	@Override
	public void crear(DocumentoDTO documento) throws SQLException {
		String sql = "INSERT INTO documento (titulo, fechapublicacion, autores, diapublicacion ,mespublicacion , editorial, estado, propietario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection conexion = ConexionDB.getInstance().getConnection();
				PreparedStatement pstmt = conexion.prepareStatement(sql)){
			pstmt.setString(1, documento.getTitulo());
			pstmt.setDate(2, convertirStringADate(documento.getFechaPublicacion()));
			pstmt.setString(3, documento.getAutores());
			pstmt.setString(4, documento.getDiaPublicacion());
			pstmt.setString(5, documento.getMesPublicacion());
			pstmt.setString(6, documento.getEditorial());
			pstmt.setString(7, documento.getEstado());
			pstmt.setInt(8, 11);
			pstmt.executeUpdate();
		}
	}

	@Override
	public DocumentoDTO buscarPorNombre(String nombre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPorID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(DocumentoDTO DTO) {
		// TODO Auto-generated method stub
		
	}
	
    public static Date convertirStringADate(String fechaStr) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("d/M/yyyy"); // Define el formato esperado
            java.util.Date fechaUtil = formato.parse(fechaStr); // Convierte a java.util.Date
            return new java.sql.Date(fechaUtil.getTime()); // Convierte a java.sql.Date
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Manejo de error: Devuelve null si hay un fallo
        }
    }



}
