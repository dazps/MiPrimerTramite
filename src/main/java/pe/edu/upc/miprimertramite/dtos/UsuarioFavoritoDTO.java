package pe.edu.upc.miprimertramite.dtos;

import pe.edu.upc.miprimertramite.entities.Tramite;
import pe.edu.upc.miprimertramite.entities.Usuario;

import java.time.LocalDateTime;

public class UsuarioFavoritoDTO {

    private int idFavorito;
    private LocalDateTime fechaAgregado;
    private Usuario usuario;
    private Tramite tramite;

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