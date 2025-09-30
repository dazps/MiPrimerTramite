package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tipo_Notificaciones")
public class TipoNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TipoNotificacion")
    private int idTipoNotificacion;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "Descripcion", length = 150)
    private String descripcion;

    @OneToMany(mappedBy = "tipoNotificacion", fetch = FetchType.LAZY)
    private List<Notificacion> notificaciones;

    public TipoNotificacion() {}

    public TipoNotificacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdTipoNotificacion() { return idTipoNotificacion; }
    public void setIdTipoNotificacion(int idTipoNotificacion) { this.idTipoNotificacion = idTipoNotificacion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Notificacion> getNotificaciones() { return notificaciones; }
    public void setNotificaciones(List<Notificacion> notificaciones) { this.notificaciones = notificaciones; }
}
