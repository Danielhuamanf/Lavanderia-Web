
package DAO.dao;
import DTO.dto.CategoriaDTO;
 import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConnection;
public class CategoriaDAO {
   
    public List<CategoriaDTO> obtenerTodos() throws SQLException, ClassNotFoundException {
        String query = "SELECT id_categoria, nombre_categoria FROM categoria";
        List<CategoriaDTO> categorias = new ArrayList<>();

        try (Connection conexion = MySQLConnection.getConnection();
             PreparedStatement ps = conexion.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int idCategoria = rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria");
                categorias.add(new CategoriaDTO(idCategoria, nombreCategoria));
            }
        }
        return categorias;
    }
    
}


