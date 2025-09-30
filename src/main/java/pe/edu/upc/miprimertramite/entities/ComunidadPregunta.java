package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comunidad_Preguntas")
public class ComunidadPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pregunta")
    private Int idPregunta;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_Tramite", nullable = false)
    private Tramite tramite;

    @Column(name = "Titulo", length = 200, nullable = false)
    private String titulo;

    @Column(name = "Contenido", nullable = false)
    private String contenido;

    @Column(name = "FechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    // Getters y Setters
    public Int getIdPregunta() { return idPregunta; }
    public void setIdPregunta(Int idPregunta) { this.idPregunta = idPregunta; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Tramite getTramite() { return tramite; }
    public void setTramite(Tramite tramite) { this.tramite = tramite; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
