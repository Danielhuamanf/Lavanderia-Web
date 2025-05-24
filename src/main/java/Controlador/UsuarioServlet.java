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

@WebServlet(name = "registrar", urlPatterns = {"/registrar"})
public class UsuarioServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contrasena = request.getParameter("contrasena");
        String direccion = request.getParameter("direccion");
        String rol = request.getParameter("rol");
        UsuarioDTO usuario = new UsuarioDTO(nombre,correo,telefono,contrasena,direccion,rol);


        String mensaje;
        String tipoMensaje;

    try {
        // Intentar registrar al usuario
        usuarioDAO.create(usuario);
        mensaje = "Usuario registrado correctamente.";
        tipoMensaje = "success"; 
        request.setAttribute("tipoMensaje", "success");
    request.setAttribute("mensaje", mensaje);
    } catch (SQLException e) {
        // Manejo de errores específicos de SQL
        if (e.getMessage().contains("Duplicate entry")) {
            mensaje = "Este correo ya está registrado.";
            
        } else {
            mensaje = "Error al registrar el usuario. Por favor, intente de nuevo.";
            
        }
           request.setAttribute("tipoMensaje", "success");
    request.setAttribute("mensaje", mensaje); 
        e.printStackTrace();
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    // Pasar el mensaje y su tipo a la vista

        /*
        try {
            int resultado = usuarioDAO.create(usuario);
            if (resultado > 0) {
                mensaje = "Usuario registrado correctamente.";
            } else {
                mensaje = "Este correo ya existe";
            }
            request.setAttribute("tipoMensaje", "success");
            request.setAttribute("mensaje", mensaje);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
