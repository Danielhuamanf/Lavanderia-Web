package Controlador;

import DAO.dao.CategoriaDAO;
import DAO.dao.ServicioDAO;
import DAO.dao.SolicitudDAO;
import DTO.dto.CategoriaDTO;
import DTO.dto.PedidoDTO;
import DTO.dto.ServicioDTO;
import DTO.dto.SolicitudDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "SolicitudServlet", urlPatterns = {"/SolicitudServlet"})
public class SolicitudServlet extends HttpServlet {
    
    private CategoriaDAO categoriaDAO;
    private ServicioDAO servicioDAO;
    private SolicitudDAO solicitudDAO;
    
    public SolicitudServlet() {
       
        categoriaDAO = new CategoriaDAO();
        servicioDAO = new ServicioDAO();
        solicitudDAO = new SolicitudDAO();
    }

    private RequestDispatcher dispatcher;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String action = request.getParameter("action");
    String ruta = "servicio.jsp"; 

    try {
        if (action == null || action.isEmpty()) {
            this.prepararFormulario(request, response, ruta);
        } else {
            switch (action) {
                case "solicitar":
                    this.prepararFormulario(request, response, ruta); 
                    break;

                case "guardarSolicitud":
                    this.guardarSolicitud(request, response, ruta); 
                    break;
                case "pedidos":
                    ruta = "Pedidos.jsp";
                    this.prepararSolicitudes(request, response, ruta); 
                    break;
                case "eliminar":
                    ruta = "Pedidos.jsp";
                    this.eliminarSolicitud(request, response, ruta); 
                    break;
                case "editar":
                    ruta = "Pedidos.jsp";
                    this.cargarIDSolicitud(request, response, ruta); 
                    break;
                default:
                    request.setAttribute("errorMensaje", "Acción no reconocida: " + action);
                    break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("errorMensaje", "Ocurrió un error: " + e.getMessage());
    }

    dispatcher = request.getRequestDispatcher(ruta);
    dispatcher.forward(request, response);
}


    private void prepararFormulario(HttpServletRequest request, HttpServletResponse response, String ruta)
            throws ServletException, IOException {
        try {
            request.setAttribute("categorias", categoriaDAO.obtenerTodos());
            request.setAttribute("servicios", servicioDAO.obtenerTodos());
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }
   protected void prepararSolicitudes(HttpServletRequest request, HttpServletResponse response, String ruta)
            throws ServletException, IOException {

        try {
            request.setAttribute("solicitudes", solicitudDAO.obtenerTodos());
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    private void guardarSolicitud(HttpServletRequest request, HttpServletResponse response, String ruta)
            throws ServletException, IOException {
        try {
            // Crear instancia de SolicitudDTO
            SolicitudDTO solicitud = new SolicitudDTO();

          
            ServicioDTO servicio = new ServicioDTO();
            CategoriaDTO categoria = new CategoriaDTO();

            
            servicio.setIdServicio(Integer.parseInt(request.getParameter("tipoServicio")));
            categoria.setIdCategoria(Integer.parseInt(request.getParameter("categoriaServicio")));

           
            solicitud.setIdServicio(servicio);
            solicitud.setIdCategoria(categoria);
            solicitud.setFechaRecoleccion(LocalDate.parse(request.getParameter("fechaRecoleccion")));
            solicitud.setHoraRecoleccion(LocalTime.parse(request.getParameter("horaRecoleccion")));
            solicitud.setFechaEntrega(LocalDate.parse(request.getParameter("fechaEntrega")));
            solicitud.setHoraEntrega(LocalTime.parse(request.getParameter("horaEntrega")));
            solicitud.setNotas(request.getParameter("notasAdicionales"));
            solicitud.setCantidad(Integer.parseInt(request.getParameter("cantidad")));

            // Calcular subtotal
            BigDecimal precioServicio = new BigDecimal(request.getParameter("precioServicio"));            
            BigDecimal subtotal = precioServicio.multiply(new BigDecimal(solicitud.getCantidad()));
            solicitud.setSubtotal(subtotal);

            // Guardar solicitud en la base de datos
           
            solicitudDAO.guardarSolicitud(solicitud);

            request.setAttribute("mensaje", "Solicitud guardada con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Error al guardar la solicitud: " + e.getMessage());
        }
    }
   

    protected void eliminarSolicitud(HttpServletRequest request, HttpServletResponse response, String ruta)
        throws ServletException, IOException {

    
    int idEliminar = Integer.parseInt(request.getParameter("id"));
    
    try {
        
        String msj = solicitudDAO.eliminar(idEliminar);


        request.setAttribute("solicitudes", solicitudDAO.obtenerTodos());
    } catch (Exception e) {
        e.printStackTrace();
        
        request.setAttribute("mensaje", "Ocurrió un error al intentar eliminar la solicitud.");
    }  
    }
    
protected void cargarIDSolicitud(HttpServletRequest request, HttpServletResponse response, String ruta)
        throws ServletException, IOException {

    int idActualiza = Integer.parseInt(request.getParameter("id"));
    
    try {
        // Cargar la solicitud por ID desde el DAO
        SolicitudDTO solicitud = solicitudDAO.llenarPorID(idActualiza);
        request.setAttribute("solicitud", solicitud);

        // Opcional: Cargar datos relacionados, como servicios o categorías
        request.setAttribute("categorias", categoriaDAO.obtenerTodos());
        request.setAttribute("servicios", servicioDAO.obtenerTodos());
    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("mensaje", "Error al cargar la solicitud para edición: " + e.getMessage());
    }

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
