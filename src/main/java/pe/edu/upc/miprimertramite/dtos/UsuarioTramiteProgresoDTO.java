package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class UsuarioTramiteProgresoDTO {
    private int idProgreso;
    private int idUsuario;
    private int idTramite;
    private int idPaso;
    private boolean completado;
    private LocalDateTime fechaCompletado;

    public UsuarioTramiteProgresoDTO() {}

    public UsuarioTramiteProgresoDTO(int idProgreso, int idUsuario, int idTramite, int idPaso, boolean completado, LocalDateTime fechaCompletado) {
        this.idProgreso = idProgreso;
        this.idUsuario = idUsuario;
        this.idTramite = idTramite;
        this.idPaso = idPaso;
        this.completado = completado;
        this.fechaCompletado = fechaCompletado;
    }

    // Getters y Setters
    public int getIdProgreso() { return idProgreso; }
    public void setIdProgreso(int idProgreso) { this.idProgreso = idProgreso; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdTramite() { return idTramite; }
    public void setIdTramite(int idTramite) { this.idTramite = idTramite; }

    public int getIdPaso() { return idPaso; }
    public void setIdPaso(int idPaso) { this.idPaso = idPaso; }

    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }

    public LocalDateTime getFechaCompletado() { return fechaCompletado; }
    public void setFechaCompletado(LocalDateTime fechaCompletado) { this.fechaCompletado = fechaCompletado; }
}
