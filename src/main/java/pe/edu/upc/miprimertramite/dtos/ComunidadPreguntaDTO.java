package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class ComunidadPreguntaDTO {
    private int idPregunta;
    private int idUsuario;
    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion;

    public ComunidadPreguntaDTO() {}

    public ComunidadPreguntaDTO(int idPregunta, int idUsuario, String titulo, String contenido, LocalDateTime fechaCreacion) {
        this.idPregunta = idPregunta;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public int getIdPregunta() { return idPregunta; }
    public void setIdPregunta(int idPregunta) { this.idPregunta = idPregunta; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
