package Controlador;

import DAO.dao.UsuarioDAO;
import DTO.dto.UsuarioDTO;
import modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    public UsuarioServlet() {
        usuarioDAO = new UsuarioDAO();
    }

    private RequestDispatcher dispatcher;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String ruta = "";

        try {

            switch (action) {
                case "registrar":
                    ruta = "registrar.jsp";
                    registrarUsuario(request, response, ruta);
                    break;
                case "login":
                    ruta = "login.jsp"; 
                    iniciarSesion(request, response, ruta);
                    break;
                default:
                    request.setAttribute("errorMensaje", "Acción no reconocida: " + action);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMensaje", "Ocurrió un error: " + e.getMessage());
        }
          
    String rutaFinal = (String) request.getAttribute("rutaFinal");
    if (rutaFinal != null) {
        ruta = rutaFinal;
    }
        dispatcher = request.getRequestDispatcher(ruta);
        dispatcher.forward(request, response);
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response, String ruta)
            throws ServletException, IOException {
        try {

            String contrasena = request.getParameter("contrasena");
            String confirmarContrasena = request.getParameter("confirmarContrasena");

            if (!contrasena.equals(confirmarContrasena)) {
                request.setAttribute("mensaje", "Error: Las contraseñas no coinciden.");
                request.getRequestDispatcher(ruta).forward(request, response);
                return;
            }

            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setCorreo(request.getParameter("correo"));
            usuario.setTelefono(request.getParameter("telefono"));
            usuario.setContrasena(contrasena); 
            usuario.setDireccion(request.getParameter("direccion"));

            int resultado = usuarioDAO.registrar(usuario);

            if (resultado > 0) {
                request.setAttribute("mensaje", "Usuario registrado exitosamente.");
            } else {
                request.setAttribute("mensaje", "Error: El correo ya existe.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Error en los datos: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Ocurrió un error al registrar el usuario.");
        } finally {
            
            request.getRequestDispatcher(ruta).forward(request, response);
        }
    }

private void iniciarSesion(HttpServletRequest request, HttpServletResponse response, String ruta)
        throws ServletException, IOException {
    String correo = request.getParameter("correo");
    String contrasena = request.getParameter("contrasena");

    try {
        Usuario usuario = new Usuario(correo, contrasena);

        if (usuarioDAO.iniciarSesion(usuario)) {
            ruta = "home.jsp"; 
        } else {
            request.setAttribute("mensaje", "Credenciales incorrectas. Por favor, inténtelo de nuevo.");
            ruta = "login.jsp"; 
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        request.setAttribute("mensaje", "Error al intentar iniciar sesión: " + e.getMessage());
        ruta = "login.jsp"; 
    }

    
    request.setAttribute("rutaFinal", ruta);
}




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
