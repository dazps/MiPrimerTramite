package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Notificacion")
    private int idNotificacion;

    @Column(name = "ID_Usuario", nullable = false)
    private int idUsuario;

    @Column(name = "ID_TipoNotificacion", nullable = false)
    private int idTipoNotificacion;

    @Column(name = "Titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "Mensaje", columnDefinition = "text")
    private String mensaje;

    @Column(name = "FechaProgramada")
    private LocalDateTime fechaProgramada;

    @Column(name = "Enviado", nullable = false)
    private boolean enviado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TipoNotificacion", insertable = false, updatable = false)
    private TipoNotificacion tipoNotificacion;

    public Notificacion() {}

    public Notificacion(int idUsuario, int idTipoNotificacion, String titulo, String mensaje, LocalDateTime fechaProgramada) {
        this.idUsuario = idUsuario;
        this.idTipoNotificacion = idTipoNotificacion;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaProgramada = fechaProgramada;
        this.enviado = false;
    }

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

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public TipoNotificacion getTipoNotificacion() { return tipoNotificacion; }
    public void setTipoNotificacion(TipoNotificacion tipoNotificacion) { this.tipoNotificacion = tipoNotificacion; }
}
