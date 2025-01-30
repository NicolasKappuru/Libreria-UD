package controlador;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/usuarios", "/usuarios/registrar", "/usuarios/login"})
public class ServletUsuario extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private GestorUsuarios gestor;
	
	public void init() throws ServletException {
        super.init();
        gestor = new GestorUsuarios();
    }
	
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    setCORSHeaders(response);  // Asegúrate de que los encabezados CORS estén bien configurados
	    response.setStatus(HttpServletResponse.SC_OK);  // Responde con un código 200 para la solicitud preflight
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	    String urlPath = request.getRequestURI().substring(request.getContextPath().length());
	    
	    if("/usuarios/registrar".equals(urlPath)) {
	    	response.getWriter().write("{\"message\": \""+gestor.registrarUsuario(keyValuePairs)+"\"}");
	    }else if("/usuarios/login".equals(urlPath)) {
	    	response.getWriter().write(gestor.loginUsuario(keyValuePairs));
	    }else {
	    	response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"message\": \"URL no encontrada\"}");
	    }
        
	}
	
	private void setCORSHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }
}
