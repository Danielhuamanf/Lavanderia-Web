package DTO.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class SolicitudDTO {

    private int idSolicitud;
    private ServicioDTO idServicio;
    private CategoriaDTO idCategoria; 
    private LocalDate fechaRecoleccion;
    private LocalTime horaRecoleccion;
    private LocalDate fechaEntrega;
    private LocalTime horaEntrega;
    private String notas;
    private int cantidad;
    private BigDecimal subtotal;

    public SolicitudDTO() {
    }

    // Constructor con todos los atributos

    public SolicitudDTO(int idSolicitud, ServicioDTO idServicio, CategoriaDTO idCategoria, LocalDate fechaRecoleccion, LocalTime horaRecoleccion, LocalDate fechaEntrega, LocalTime horaEntrega, String notas, int cantidad, BigDecimal subtotal) {
        this.idSolicitud = idSolicitud;

        this.idServicio = idServicio;
        this.idCategoria = idCategoria;
        this.fechaRecoleccion = fechaRecoleccion;
        this.horaRecoleccion = horaRecoleccion;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.notas = notas;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
   

    // Getters y Setters
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    public ServicioDTO getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(ServicioDTO idServicio) {
        this.idServicio = idServicio;
    }

    public CategoriaDTO getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaDTO idCategoria) {
        this.idCategoria = idCategoria;
    }

   

    public LocalDate getFechaRecoleccion() {
        return fechaRecoleccion;
    }

    public void setFechaRecoleccion(LocalDate fechaRecoleccion) {
        this.fechaRecoleccion = fechaRecoleccion;
    }

    public LocalTime getHoraRecoleccion() {
        return horaRecoleccion;
    }

    public void setHoraRecoleccion(LocalTime horaRecoleccion) {
        this.horaRecoleccion = horaRecoleccion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalTime getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(LocalTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    // Método para calcular el subtotal basado en cantidad y precio unitario
    public void calcularSubtotal(BigDecimal precioUnitario) {
        this.subtotal = precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

    @Override
    public String toString() {
        return "Solicitud{"
                + "idSolicitud=" + idSolicitud
                + ", idServicio=" + idServicio
                + ", idCategoria=" + idCategoria
                + ", fechaRecoleccion=" + fechaRecoleccion
                + ", horaRecoleccion=" + horaRecoleccion
                + ", fechaEntrega=" + fechaEntrega
                + ", horaEntrega=" + horaEntrega
                + ", notas='" + notas + '\''
                + ", cantidad=" + cantidad
                + ", subtotal=" + subtotal
                + '}';
    }
}
