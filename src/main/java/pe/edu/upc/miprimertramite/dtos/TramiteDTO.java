package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class TramiteDTO {
    private int idTramite;
    private String titulo;
    private String descripcion;
    private int popularidad;
    private LocalDateTime actualizadoEn;

    public TramiteDTO() {}

    public TramiteDTO(int idTramite, String titulo, String descripcion, int popularidad, LocalDateTime actualizadoEn) {
        this.idTramite = idTramite;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.popularidad = popularidad;
        this.actualizadoEn = actualizadoEn;
    }

    // Getters y Setters
    public int getIdTramite() { return idTramite; }
    public void setIdTramite(int idTramite) { this.idTramite = idTramite; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getPopularidad() { return popularidad; }
    public void setPopularidad(int popularidad) { this.popularidad = popularidad; }

    public LocalDateTime getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(LocalDateTime actualizadoEn) { this.actualizadoEn = actualizadoEn; }
}
