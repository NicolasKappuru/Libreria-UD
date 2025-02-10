package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.FachadaSistema;

@WebServlet({"/usuario/datos", "/usuario/registrar", "/usuario/login"})
public class ServletUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FachadaSistema gestor;

    public void init() throws ServletException {
        super.init();
        gestor = FachadaSistema.getInstancia();
    }

    // Manejo de las solicitudes OPTIONS para permitir CORS
    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCORSHeaders(response);
        response.setStatus(HttpServletResponse.SC_OK);  // Responde con 200 OK
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCORSHeaders(response);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String urlPath = request.getRequestURI().substring(request.getContextPath().length());
        String jsonResponse;

        if ("/usuario/registrar".equals(urlPath)) {
            jsonResponse = gestor.registrarUsuario(request);
        } else if ("/usuario/login".equals(urlPath)) {
            jsonResponse = gestor.loginUsuario(request);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            jsonResponse = "{\"mensaje\": \"URL no encontrada\"}";
        }

        response.getWriter().write(jsonResponse);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCORSHeaders(response);
        String usuario = (String) request.getAttribute("usuario");
        String jsonResponse = gestor.obtenerUsuario(usuario);
        response.getWriter().write(jsonResponse);
    }

    // Método para agregar los encabezados CORS
    private void setCORSHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }
}

