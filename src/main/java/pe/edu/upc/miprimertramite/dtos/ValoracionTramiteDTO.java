package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class ValoracionTramiteDTO {
    private int idValoracion;
    private int idUsuario;
    private int idTramite;
    private int puntuacion;
    private String comentario;
    private LocalDateTime fecha;

    public ValoracionTramiteDTO() {}

    public ValoracionTramiteDTO(int idValoracion, int idUsuario, int idTramite, int puntuacion, String comentario, LocalDateTime fecha) {
        this.idValoracion = idValoracion;
        this.idUsuario = idUsuario;
        this.idTramite = idTramite;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdValoracion() { return idValoracion; }
    public void setIdValoracion(int idValoracion) { this.idValoracion = idValoracion; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdTramite() { return idTramite; }
    public void setIdTramite(int idTramite) { this.idTramite = idTramite; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
