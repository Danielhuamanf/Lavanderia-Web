/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.dao;
import DTO.dto.CategoriaDTO;
import DTO.dto.ServicioDTO;
import DTO.dto.SolicitudDTO;
   import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConnection;

/**
 *
 * @author Usuario
 */

public class SolicitudDAO {
 
     public void guardarSolicitud(SolicitudDTO solicitud) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO solicitud (id_servicio, id_categoria, fecha_recoleccion, hora_recoleccion, " +
                       "fecha_entrega, hora_entrega, notas, cantidad, subtotal) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = MySQLConnection.getConnection();
             PreparedStatement ps = conexion.prepareStatement(query)) {
           
            ps.setInt(1, solicitud.getIdServicio().getIdServicio());
            ps.setInt(2, solicitud.getIdCategoria().getIdCategoria());
            ps.setDate(3, Date.valueOf(solicitud.getFechaRecoleccion()));
            ps.setTime(4, Time.valueOf(solicitud.getHoraRecoleccion()));
            ps.setDate(5, Date.valueOf(solicitud.getFechaEntrega()));
            ps.setTime(6, Time.valueOf(solicitud.getHoraEntrega()));
            ps.setString(7, solicitud.getNotas());
            ps.setInt(8, solicitud.getCantidad());
            ps.setBigDecimal(9, solicitud.getSubtotal());
            ps.executeUpdate();
        }
    }
    public String eliminar(int idSolicitud) throws SQLException, ClassNotFoundException {
    String query = "DELETE FROM solicitud WHERE id_solicitud = ?";
    try (Connection conexion = MySQLConnection.getConnection();
         PreparedStatement ps = conexion.prepareStatement(query)) {
        ps.setInt(1, idSolicitud);
        int filasAfectadas = ps.executeUpdate();
        if (filasAfectadas > 0) {
            return "Solicitud eliminada correctamente";
        } else {
            return "No se encontró la solicitud a eliminar";
        }
    }
}
    public List<SolicitudDTO> obtenerTodos() throws SQLException, ClassNotFoundException {
    String query = "SELECT s.id_solicitud, ser.id_servicio, ser.nombre_servicio, ser.descripcion, ser.precio_base, ser.tiempo_estimado, " +
                   "cat.id_categoria, cat.nombre_categoria, s.fecha_recoleccion, s.hora_recoleccion, " +
                   "s.fecha_entrega, s.hora_entrega, s.notas, s.cantidad, s.subtotal " +
                   "FROM solicitud s " +
                   "INNER JOIN servicio ser ON s.id_servicio = ser.id_servicio " +
                   "LEFT JOIN categoria cat ON s.id_categoria = cat.id_categoria";

    List<SolicitudDTO> listaSolicitudes = new ArrayList<>();

    try (Connection conexion = MySQLConnection.getConnection();
         PreparedStatement ps = conexion.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            
            ServicioDTO servicio = new ServicioDTO();
            servicio.setIdServicio(rs.getInt("id_servicio"));
            servicio.setNombreServicio(rs.getString("nombre_servicio"));
            servicio.setDescripcion(rs.getString("descripcion"));
            servicio.setPrecioBase(rs.getBigDecimal("precio_base"));
            servicio.setTiempoEstimado(rs.getInt("tiempo_estimado"));

            CategoriaDTO categoria = new CategoriaDTO();
            categoria.setIdCategoria(rs.getInt("id_categoria"));
            categoria.setNombreCategoria(rs.getString("nombre_categoria"));
            

            SolicitudDTO solicitud = new SolicitudDTO();
            solicitud.setIdSolicitud(rs.getInt("id_solicitud"));
            solicitud.setIdServicio(servicio);
            solicitud.setIdCategoria(categoria);
            solicitud.setFechaRecoleccion(rs.getDate("fecha_recoleccion").toLocalDate());
            solicitud.setHoraRecoleccion(rs.getTime("hora_recoleccion").toLocalTime());
            solicitud.setFechaEntrega(rs.getDate("fecha_entrega").toLocalDate());
            solicitud.setHoraEntrega(rs.getTime("hora_entrega").toLocalTime());
            solicitud.setNotas(rs.getString("notas"));
            solicitud.setCantidad(rs.getInt("cantidad"));
            solicitud.setSubtotal(rs.getBigDecimal("subtotal"));

            listaSolicitudes.add(solicitud);
        }
    }

    return listaSolicitudes;
}
    public SolicitudDTO llenarPorID(int id) throws Exception {
    SolicitudDTO solicitud = null;

    try (Connection conexion = MySQLConnection.getConnection()) {
        String query = "SELECT * FROM solicitud WHERE id_solicitud = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ServicioDTO servicio = new ServicioDTO();
            CategoriaDTO categoria = new CategoriaDTO();
            solicitud = new SolicitudDTO();
            solicitud.setIdSolicitud(rs.getInt("id_solicitud"));
            servicio.setIdServicio(rs.getInt("id_servicio"));
            categoria.setIdCategoria(rs.getInt("id_categoria"));
            solicitud.setIdServicio(servicio);
            solicitud.setIdCategoria(categoria);
            solicitud.setFechaRecoleccion(rs.getDate("fecha_recoleccion").toLocalDate());
            solicitud.setHoraRecoleccion(rs.getTime("hora_recoleccion").toLocalTime());
            solicitud.setFechaEntrega(rs.getDate("fecha_entrega").toLocalDate());
            solicitud.setHoraEntrega(rs.getTime("hora_entrega").toLocalTime());
            solicitud.setNotas(rs.getString("notas"));
            solicitud.setCantidad(rs.getInt("cantidad"));
            solicitud.setSubtotal(rs.getBigDecimal("subtotal"));
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception("Error al obtener la solicitud por ID: " + e.getMessage());
    }

    return solicitud;
}
public void actualizarSolicitud(SolicitudDTO solicitud) throws SQLException, ClassNotFoundException {
    String query = "UPDATE solicitud " +
                   "SET id_servicio = ?, id_categoria = ?, fecha_recoleccion = ?, hora_recoleccion = ?, " +
                   "fecha_entrega = ?, hora_entrega = ?, notas = ?, cantidad = ?, subtotal = ? " +
                   "WHERE id_solicitud = ?";

    try (Connection conexion = MySQLConnection.getConnection();
         PreparedStatement ps = conexion.prepareStatement(query)) {
        
        ps.setInt(1, solicitud.getIdServicio().getIdServicio());
        ps.setInt(2, solicitud.getIdCategoria() != null ? solicitud.getIdCategoria().getIdCategoria() : null);
        ps.setDate(3, Date.valueOf(solicitud.getFechaRecoleccion()));
        ps.setTime(4, Time.valueOf(solicitud.getHoraRecoleccion()));
        ps.setDate(5, Date.valueOf(solicitud.getFechaEntrega()));
        ps.setTime(6, Time.valueOf(solicitud.getHoraEntrega()));
        ps.setString(7, solicitud.getNotas());
        ps.setInt(8, solicitud.getCantidad());
        ps.setBigDecimal(9, solicitud.getSubtotal());
        ps.setInt(10, solicitud.getIdSolicitud());
        
        ps.executeUpdate();
    }
}





}

