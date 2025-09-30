package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class NotificacionDTO {
    private int idNotificacion;
    private int idUsuario;
    private int idTipoNotificacion;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaProgramada;
    private boolean enviado;

    public NotificacionDTO() {}

    public NotificacionDTO(int idNotificacion, int idUsuario, int idTipoNotificacion, String titulo, String mensaje, LocalDateTime fechaProgramada, boolean enviado) {
        this.idNotificacion = idNotificacion;
        this.idUsuario = idUsuario;
        this.idTipoNotificacion = idTipoNotificacion;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaProgramada = fechaProgramada;
        this.enviado = enviado;
    }

    // Getters y Setters
    public int getIdNotificacion() { return idNotificacion; }
    public void setIdNotificacion(int idNotificacion) { this.idNotificacion = idNotificacion; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdTipoNotificacion() { return idTipoNotificacion; }
    public void setIdTipoNotificacion(int idTipoNotificacion) { this.idTipoNotificacion = idTipoNotificacion; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFechaProgramada() { return fechaProgramada; }
    public void setFechaProgramada(LocalDateTime fechaProgramada) { this.fechaProgramada = fechaProgramada; }

    public boolean isEnviado() { return enviado; }
    public void setEnviado(boolean enviado) { this.enviado = enviado; }
}
