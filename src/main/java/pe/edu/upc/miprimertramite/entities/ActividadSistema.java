package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Actividad_Sistema")
public class ActividadSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Actividad")
    private int idActividad;

    @Column(name = "ID_Usuario", nullable = false)
    private int idUsuario;

    @Column(name = "TipoActividad", nullable = false, length = 50)
    private String tipoActividad;

    @Column(name = "Descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "Fecha")
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Usuario", insertable = false, updatable = false)
    private Usuario usuario;

    public ActividadSistema() {}

    public ActividadSistema(int idUsuario, String tipoActividad, String descripcion) {
        this.idUsuario = idUsuario;
        this.tipoActividad = tipoActividad;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
    }

    public int getIdActividad() { return idActividad; }
    public void setIdActividad(int idActividad) { this.idActividad = idActividad; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getTipoActividad() { return tipoActividad; }
    public void setTipoActividad(String tipoActividad) { this.tipoActividad = tipoActividad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
