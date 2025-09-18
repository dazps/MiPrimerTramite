package com.example.miprimertramitegithub2025;

public class Usuario {
    private long idUsuario;
    private String nombreCompleto;
    private String email;
    private String password;
    private String telefono;

    // Constructor vacío
    public Usuario() {}

    // Constructor
    public Usuario(String nombreCompleto, String email, String password, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    // Getters y Setters
    public long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(long idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
