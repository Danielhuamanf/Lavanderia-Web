
package DAO.dao;
import DTO.dto.ServicioDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConnection;

public class ServicioDAO {


    // Método para insertar un nuevo servicio
    public void create(ServicioDTO servicio) throws SQLException, ClassNotFoundException {
        String insertarServicio = "INSERT INTO servicios (nombre_servicio, descripcion, precio_base, tiempo_estimado) " +
                                   "VALUES (?, ?, ?, ?);";

        try (Connection conexion = MySQLConnection.getConnection(); 
             PreparedStatement ps = conexion.prepareStatement(insertarServicio)) {
            ps.setString(1, servicio.getNombreServicio());
            ps.setString(2, servicio.getDescripcion());
            ps.setBigDecimal(3, servicio.getPrecioBase());
            ps.setInt(4, servicio.getTiempoEstimado());
            ps.executeUpdate();
        }
    }

    // Método para obtener todos los servicios
    public List<ServicioDTO> obtenerTodos() throws SQLException, ClassNotFoundException {
        String obtenerServicios = "SELECT * FROM servicio;";
        List<ServicioDTO> servicios = new ArrayList<>();

        try (Connection conexion = MySQLConnection.getConnection();
             PreparedStatement ps = conexion.prepareStatement(obtenerServicios);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ServicioDTO servicio = new ServicioDTO();
                servicio.setIdServicio(rs.getInt("id_servicio"));
                servicio.setNombreServicio(rs.getString("nombre_servicio"));
                servicio.setDescripcion(rs.getString("descripcion"));
                servicio.setPrecioBase(rs.getBigDecimal("precio_base"));
                servicio.setTiempoEstimado(rs.getInt("tiempo_estimado"));
                servicios.add(servicio);
            }
        }
        return servicios;
    }

    // Método para buscar un servicio por ID
    public ServicioDTO buscarPorId(int idServicio) throws SQLException, ClassNotFoundException {
        String buscarServicio = "SELECT * FROM servicios WHERE id_servicio = ?;";
        ServicioDTO servicio = null;

        try (Connection conexion = MySQLConnection.getConnection();
             PreparedStatement ps = conexion.prepareStatement(buscarServicio)) {
            ps.setInt(1, idServicio);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    servicio = new ServicioDTO();
                    servicio.setIdServicio(rs.getInt("id_servicio"));
                    servicio.setNombreServicio(rs.getString("nombre_servicio"));
                    servicio.setDescripcion(rs.getString("descripcion"));
                    servicio.setPrecioBase(rs.getBigDecimal("precio_base"));
                    servicio.setTiempoEstimado(rs.getInt("tiempo_estimado"));
                }
            }
        }
        return servicio;
    }

    // Método para actualizar un servicio
    public void actualizar(ServicioDTO servicio) throws SQLException, ClassNotFoundException {
        String actualizarServicio = "UPDATE servicios SET nombre_servicio = ?, descripcion = ?, " +
                                    "precio_base = ?, tiempo_estimado = ? WHERE id_servicio = ?;";

        try (Connection conexion = MySQLConnection.getConnection(); 
             PreparedStatement ps = conexion.prepareStatement(actualizarServicio)) {
            ps.setString(1, servicio.getNombreServicio());
            ps.setString(2, servicio.getDescripcion());
            ps.setBigDecimal(3, servicio.getPrecioBase());
            ps.setInt(4, servicio.getTiempoEstimado());
            ps.setInt(5, servicio.getIdServicio());
            ps.executeUpdate();
        }
    }

    // Método para eliminar un servicio
    public void eliminar(int idServicio) throws SQLException, ClassNotFoundException {
        String eliminarServicio = "DELETE FROM servicios WHERE id_servicio = ?;";

        try (Connection conexion = MySQLConnection.getConnection(); 
             PreparedStatement ps = conexion.prepareStatement(eliminarServicio)) {
            ps.setInt(1, idServicio);
            ps.executeUpdate();
        }
    }

}
