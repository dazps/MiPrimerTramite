package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class ActividadSistemaDTO {
    private int idActividad;
    private int idUsuario;
    private String tipoActividad;
    private String descripcion;
    private LocalDateTime fecha;

    public ActividadSistemaDTO() {
    }

    public ActividadSistemaDTO(int idActividad, int idUsuario, String tipoActividad, String descripcion, LocalDateTime fecha) {
        this.idActividad = idActividad;
        this.idUsuario = idUsuario;
        this.tipoActividad = tipoActividad;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}