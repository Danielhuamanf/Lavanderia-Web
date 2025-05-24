
package Controlador;



import DAO.dao.UsuarioDAO;
import modelo.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "login", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {
private UsuarioDAO usuarioDao = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        Usuario usuario = new Usuario(correo,contrasena);

        try {
            if (usuarioDao.iniciarSesion(usuario)) {
                response.sendRedirect("home.jsp");
            } else {
                
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
        Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
