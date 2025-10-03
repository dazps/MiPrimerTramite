package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "UsuarioFavorito")
public class UsuarioFavorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFavorito;

    @Column(name = "fechaAgregado", nullable = false)
    private LocalDateTime fechaAgregado;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idTramite")
    private Tramite tramite;

    public UsuarioFavorito() {

    }

    public UsuarioFavorito(int idFavorito, LocalDateTime fechaAgregado, Usuario usuario, Tramite tramite) {
        this.idFavorito = idFavorito;
        this.fechaAgregado = fechaAgregado;
        this.usuario = usuario;
        this.tramite = tramite;
    }

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public LocalDateTime getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(LocalDateTime fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
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
}