package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Usuario")
    private int idUsuario;

    @Column(name = "ID_TipoUsuario", nullable = false)
    private int idTipoUsuario;

    @Column(name = "NombreCompleto", nullable = false, length = 150)
    private String nombreCompleto;

    @Column(name = "Email", nullable = false, length = 150)
    private String email;

    @Column(name = "Password", nullable = false, length = 150)
    private String password;

    @Column(name = "Telefono", length = 30)
    private String telefono;

    @Column(name = "UltimoLogin")
    private LocalDateTime ultimoLogin;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TipoUsuario", insertable = false, updatable = false)
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<ValoracionTramite> valoraciones;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<UsuarioFavorito> favoritos;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<ComunidadPregunta> preguntas;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<ComunidadRespuesta> respuestas;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Notificacion> notificaciones;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<ActividadSistema> actividades;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<UsuarioTramiteProgreso> progresos;

    // Constructores
    public Usuario() {}

    public Usuario(int idTipoUsuario, String nombreCompleto, String email, String password, String telefono) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.ultimoLogin = null;
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

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public LocalDateTime getUltimoLogin() { return ultimoLogin; }
    public void setUltimoLogin(LocalDateTime ultimoLogin) { this.ultimoLogin = ultimoLogin; }

    public TipoUsuario getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public List<ValoracionTramite> getValoraciones() { return valoraciones; }
    public void setValoraciones(List<ValoracionTramite> valoraciones) { this.valoraciones = valoraciones; }

    public List<UsuarioFavorito> getFavoritos() { return favoritos; }
    public void setFavoritos(List<UsuarioFavorito> favoritos) { this.favoritos = favoritos; }

    public List<ComunidadPregunta> getPreguntas() { return preguntas; }
    public void setPreguntas(List<ComunidadPregunta> preguntas) { this.preguntas = preguntas; }

    public List<ComunidadRespuesta> getRespuestas() { return respuestas; }
    public void setRespuestas(List<ComunidadRespuesta> respuestas) { this.respuestas = respuestas; }

    public List<Notificacion> getNotificaciones() { return notificaciones; }
    public void setNotificaciones(List<Notificacion> notificaciones) { this.notificaciones = notificaciones; }

    public List<ActividadSistema> getActividades() { return actividades; }
    public void setActividades(List<ActividadSistema> actividades) { this.actividades = actividades; }

    public List<UsuarioTramiteProgreso> getProgresos() { return progresos; }
    public void setProgresos(List<UsuarioTramiteProgreso> progresos) { this.progresos = progresos; }
}
