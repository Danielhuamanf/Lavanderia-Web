
package DTO.dto;

public class UsuarioDTO {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;
    private String direccion;
    

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public UsuarioDTO(String nombre, String correo, String telefono, String contrasena, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.direccion = direccion;
       
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getContrasena() {
        return contrasena;
    }
    public String getDireccion() {
        return direccion;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
}
