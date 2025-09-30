package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class ComunidadRespuestaDTO {
    private int idRespuesta;
    private int idPregunta;
    private int idUsuario;
    private String contenido;
    private LocalDateTime fechaCreacion;

    public ComunidadRespuestaDTO() {}

    public ComunidadRespuestaDTO(int idRespuesta, int idPregunta, int idUsuario, String contenido, LocalDateTime fechaCreacion) {
        this.idRespuesta = idRespuesta;
        this.idPregunta = idPregunta;
        this.idUsuario = idUsuario;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public int getIdRespuesta() { return idRespuesta; }
    public void setIdRespuesta(int idRespuesta) { this.idRespuesta = idRespuesta; }

    public int getIdPregunta() { return idPregunta; }
    public void setIdPregunta(int idPregunta) { this.idPregunta = idPregunta; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
