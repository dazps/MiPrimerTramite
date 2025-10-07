package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_favorito")
public class UsuarioFavorito {

    @Id
    @GeneratedValue
    private int idFavorito;

    @Column(name = "fecha_agregado", nullable = false)
    private LocalDateTime fechaAgregado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_tramite")
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