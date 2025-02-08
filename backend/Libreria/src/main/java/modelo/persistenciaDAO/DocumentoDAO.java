package modelo.persistenciaDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import modelo.DocumentoDTO.DocumentoDTO;
import modelo.persistencia.ConexionDB;

public class DocumentoDAO{

	public int crear(DocumentoDTO documento) throws SQLException {
		
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
			int affectedRows = pstmt.executeUpdate();
	        
	        if (affectedRows > 0) {
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    return generatedKeys.getInt(1);
	                }
	            }
	        }
	    }
	    return -1;
}
	

	public DocumentoDTO buscarPorNombre(String nombre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void eliminarPorID(int id) throws SQLException {
	    String sql = "DELETE FROM documento WHERE iddocumento = ?";
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, id);
	        pstmt.executeUpdate();
	    }
	}

	public void actualizar(DocumentoDTO documento) throws SQLException {
	    String sql = "UPDATE documento SET titulo = ?, fechapublicacion = ?, autores = ?, diapublicacion = ?, " +
	                 "mespublicacion = ?, editorial = ?, estado = ?, propietario = ? WHERE iddocumento = ?";
	    
	    try (Connection conn = ConexionDB.getInstance().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, documento.getTitulo());
	        pstmt.setDate(2, convertirStringADate(documento.getFechaPublicacion()));
	        pstmt.setString(3, documento.getAutores());
	        pstmt.setString(4, documento.getDiaPublicacion());
	        pstmt.setString(5, documento.getMesPublicacion());
	        pstmt.setString(6, documento.getEditorial());
	        pstmt.setString(7, documento.getEstado());
	        pstmt.setInt(8, Integer.parseInt(documento.getPropietario()));
	        pstmt.setInt(9, documento.getIdDocumento()); // Se usa el ID del objeto DTO
			pstmt.executeUpdate();
	    }
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

    public DocumentoDTO buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM documento WHERE iddocumento = ?";
        try (Connection conn = ConexionDB.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString("titulo"));
                    return new DocumentoDTO.BuilderDoc()
                            .setIdDocumento(rs.getInt("iddocumento"))
                            .setTitulo(rs.getString("titulo"))
                            .setFechaPublicacion(rs.getString("fechapublicacion"))
                            .setAutores(rs.getString("autores"))
                            .setDiaPublicacion(rs.getString("diapublicacion"))
                            .setMesPublicacion(rs.getString("mespublicacion"))
                            .setEditorial(rs.getString("editorial"))
                            .setEstado(rs.getString("estado"))
                            .setPropietario(rs.getString("propietario"))
                            .build();
                }
            }
        }
        return null;
    }




}
