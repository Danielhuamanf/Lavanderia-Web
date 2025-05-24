
package modelo;

public class Usuario {
    
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;
    private String direccion;
    private String rol;

    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario(String nombre, String correo, String telefono, String contrasena, String direccion, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.rol = rol;
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
    public String getRol() {
        return rol;
    }
}
