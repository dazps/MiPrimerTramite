package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ActividadSistema")
public class ActividadSistema {

    @Id
    @GeneratedValue
    private int idActividad;

    @Column(name = "TipoActividad", length = 50, nullable = false)
    private String tipoActividad;

    @Column(name = "Descripcion", length = 255, nullable = false)
    private String descripcion;

    @Column(name = "Fecha", nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public ActividadSistema(){
    }

    public ActividadSistema(int idActividad, String tipoActividad, String descripcion, LocalDateTime fecha, Usuario usuario) {
        this.idActividad = idActividad;
        this.tipoActividad = tipoActividad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}