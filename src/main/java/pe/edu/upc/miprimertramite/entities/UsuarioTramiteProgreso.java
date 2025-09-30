package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuario_Tramite_Progreso")
public class UsuarioTramiteProgreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Progreso")
    private int idProgreso;

    @Column(name = "ID_Usuario", nullable = false)
    private int idUsuario;

    @Column(name = "ID_Tramite", nullable = false)
    private int idTramite;

    @Column(name = "ID_Paso", nullable = false)
    private int idPaso;

    @Column(name = "Completado", nullable = false)
    private boolean completado;

    @Column(name = "FechaCompletado")
    private LocalDateTime fechaCompletado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Tramite", insertable = false, updatable = false)
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Paso", insertable = false, updatable = false)
    private TramitePaso paso;

    public UsuarioTramiteProgreso() {}

    public UsuarioTramiteProgreso(int idUsuario, int idTramite, int idPaso, boolean completado) {
        this.idUsuario = idUsuario;
        this.idTramite = idTramite;
        this.idPaso = idPaso;
        this.completado = completado;
        this.fechaCompletado = completado ? LocalDateTime.now() : null;
    }

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

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Tramite getTramite() { return tramite; }
    public void setTramite(Tramite tramite) { this.tramite = tramite; }

    public TramitePaso getPaso() { return paso; }
    public void setPaso(TramitePaso paso) { this.paso = paso; }
}
