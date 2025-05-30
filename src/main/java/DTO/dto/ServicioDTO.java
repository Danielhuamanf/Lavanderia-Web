
package DTO.dto;
import java.math.BigDecimal;

public class ServicioDTO {
 
    private int idServicio;
    private String nombreServicio;
    private String descripcion;
    private BigDecimal precioBase;
    private int tiempoEstimado;

   
    public ServicioDTO() {
    }

    
    public ServicioDTO(int idServicio, String nombreServicio, String descripcion, BigDecimal precioBase, int tiempoEstimado) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.tiempoEstimado = tiempoEstimado;
    }

    
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    
    @Override
    public String toString() {
        return "ServicioDTO{" +
                "idServicio=" + idServicio +
                ", nombreServicio='" + nombreServicio + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioBase=" + precioBase +
                ", tiempoEstimado=" + tiempoEstimado +
                '}';
    }
}
   

