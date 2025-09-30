package pe.edu.upc.miprimertramite.dtos;

import java.time.LocalDateTime;

public class UsuarioDTO {
    private int idUsuario;
    private int idTipoUsuario;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private LocalDateTime ultimoLogin;

    public UsuarioDTO() {}

    public UsuarioDTO(int idUsuario, int idTipoUsuario, String nombreCompleto, String email, String telefono, LocalDateTime ultimoLogin) {
        this.idUsuario = idUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
        this.ultimoLogin = ultimoLogin;
    }

    // Getters y Setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdTipoUsuario() { return idTipoUsuario; }
    public void setIdTipoUsuario(int idTipoUsuario) { this.idTipoUsuario = idTipoUsuario; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public LocalDateTime getUltimoLogin() { return ultimoLogin; }
    public void setUltimoLogin(LocalDateTime ultimoLogin) { this.ultimoLogin = ultimoLogin; }
}
