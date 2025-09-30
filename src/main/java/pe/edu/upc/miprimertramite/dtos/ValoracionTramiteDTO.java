package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class ValoracionTramiteDTO {
    private int idValoracion;
    private int idusuario;
    private int idtramite;
    private int puntuacion;
    private String comentario;
    private LocalDateTime fechaValoracion;

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdtramite() {
        return idtramite;
    }

    public void setIdtramite(int idtramite) {
        this.idtramite = idtramite;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(LocalDateTime fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }
}

