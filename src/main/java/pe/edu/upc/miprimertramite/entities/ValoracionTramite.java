package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ValoracionTramite")
public class ValoracionTramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idValoracion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idTramite", nullable = false)
    private Tramite tramite;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    @Column(name = "comentario", length = 100)
    private String comentario;

    @Column(name = "fechaValoracion", nullable = false)
    private LocalDateTime fechaValoracion;

    // Constructor vacío
    public ValoracionTramite () {}

    // Constructor con parámetros
    public ValoracionTramite(Usuario usuario, Tramite tramite, int puntuacion, String comentario, LocalDateTime fechaValoracion) {
        this.usuario = usuario;
        this.tramite = tramite;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fechaValoracion = fechaValoracion;
    }

    // Getters y Setters
    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
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

