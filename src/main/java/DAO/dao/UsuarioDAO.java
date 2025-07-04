
package DAO.dao;

import DTO.dto.UsuarioDTO;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.MySQLConnection;

public class UsuarioDAO {


    public UsuarioDTO read(String correo) throws SQLException, ClassNotFoundException {
        String consultarUsuario = "SELECT * FROM usuarios WHERE correo = ?;";
        UsuarioDTO usuario = null;

        try (Connection conexion = MySQLConnection.getConnection(); 
                PreparedStatement ps = conexion.prepareStatement(consultarUsuario)) {
            ps.setString(1, correo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioDTO(
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("telefono"),
                            rs.getString("contrasena"),
                            rs.getString("direccion")
                            
                    );
                }
            }
        }

        return usuario;
    }

    public void update(UsuarioDTO usuario) throws SQLException, ClassNotFoundException {
        String actualizarUsuario = "UPDATE usuarios SET nombre = ?, telefono = ?, contrasena = ?, direccion = ?, rol = ? WHERE correo = ?;";

        try (Connection conexion = MySQLConnection.getConnection(); PreparedStatement ps = conexion.prepareStatement(actualizarUsuario)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getTelefono());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getDireccion());          
            ps.setString(6, usuario.getCorreo());

            ps.executeUpdate();
        }
    }

    public void delete(String correo) throws SQLException, ClassNotFoundException {
        String eliminarUsuario = "DELETE FROM usuarios WHERE correo = ?;";

        try (Connection conexion = MySQLConnection.getConnection(); PreparedStatement ps = conexion.prepareStatement(eliminarUsuario)) {
            ps.setString(1, correo);
            ps.executeUpdate();
        }
    }

    public boolean iniciarSesion(Usuario usuario) throws SQLException, ClassNotFoundException {

        String verificacion = "select * from usuarios where correo = ? and contrasena = ? ";
        boolean status = false;

        try (Connection conexion = MySQLConnection.getConnection(); 
                PreparedStatement ps = conexion.prepareStatement(verificacion)) {
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getContrasena());

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            status = rs.next();

        }
        if (status == false) {
            System.out.println("no existe");
        }
        return status;

    }
    
     public int registrar(UsuarioDTO usuarioDTO)throws ClassNotFoundException, SQLException{
        String insertarUsuarios = "INSERT INTO usuarios" + "(nombre,correo,telefono,contrasena,direccion) VALUES"+
                "(?,?,?,?,?);";
        int result = 0;
         
        
        try(Connection conexion = MySQLConnection.getConnection();
           PreparedStatement ps = conexion.prepareStatement(insertarUsuarios)){
           ps.setString(1,usuarioDTO.getNombre());
           ps.setString(2,usuarioDTO.getCorreo());
           ps.setString(3,usuarioDTO.getTelefono());
           ps.setString(4,usuarioDTO.getContrasena());
           ps.setString(5,usuarioDTO.getDireccion());
            System.out.println(ps);
            result = ps.executeUpdate();
        }return result;
    }
}
