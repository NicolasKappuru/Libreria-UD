package controlador;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/documento/crear", "/documento/modificar", "/documento/eliminar"})
public class ServletDocumentos extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private GestorDocumentos gestor ;
	
	public void init() throws ServletException {
        super.init();
        gestor = new GestorDocumentos();
        
    }
	
	 // Manejo de las solicitudes OPTIONS para permitir CORS
    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCORSHeaders(response);
        response.setStatus(HttpServletResponse.SC_OK);  // Responde con 200 OK
    }
    
    // Método para agregar los encabezados CORS
    private void setCORSHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	setCORSHeaders(response);
    	response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }
        }
        String jsonString = jsonBuffer.toString();
        jsonString = jsonString.replaceAll("[{}\"\\[\\]]", "");
        String[] keyValuePairs = jsonString.split(",");
        String usuario = (String) request.getAttribute("usuario");
        response.getWriter().write(gestor.crearDocumento(keyValuePairs, usuario));
    }
}
