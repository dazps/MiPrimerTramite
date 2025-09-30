package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class UsuarioFavoritoDTO {
    private int idFavorito;
    private int idUsuario;
    private int idTramite;
    private LocalDateTime fechaAgregado;

    public UsuarioFavoritoDTO() {}

    public UsuarioFavoritoDTO(int idFavorito, int idUsuario, int idTramite, LocalDateTime fechaAgregado) {
        this.idFavorito = idFavorito;
        this.idUsuario = idUsuario;
        this.idTramite = idTramite;
        this.fechaAgregado = fechaAgregado;
    }

    // Getters y Setters
    public int getIdFavorito() { return idFavorito; }
    public void setIdFavorito(int idFavorito) { this.idFavorito = idFavorito; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdTramite() { return idTramite; }
    public void setIdTramite(int idTramite) { this.idTramite = idTramite; }

    public LocalDateTime getFechaAgregado() { return fechaAgregado; }
    public void setFechaAgregado(LocalDateTime fechaAgregado) { this.fechaAgregado = fechaAgregado; }
}
