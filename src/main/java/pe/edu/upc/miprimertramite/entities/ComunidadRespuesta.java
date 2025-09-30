package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comunidad_Respuestas")
public class ComunidadRespuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Respuesta")
    private int idRespuesta;

    @Column(name = "ID_Pregunta", nullable = false)
    private int idPregunta;

    @Column(name = "ID_Usuario", nullable = false)
    private int idUsuario;

    @Column(name = "Contenido", columnDefinition = "text")
    private String contenido;

    @Column(name = "FechaCreacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Pregunta", insertable = false, updatable = false)
    private ComunidadPregunta pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Usuario", insertable = false, updatable = false)
    private Usuario usuario;

    public ComunidadRespuesta() {}

    public ComunidadRespuesta(int idPregunta, int idUsuario, String contenido) {
        this.idPregunta = idPregunta;
        this.idUsuario = idUsuario;
        this.contenido = contenido;
        this.fechaCreacion = LocalDateTime.now();
    }

    public int getIdRespuesta() { return idRespuesta; }
    public void setIdRespuesta(int idRespuesta) { this.idRespuesta = idRespuesta; }

    public int getIdPregunta() { return idPregunta; }
    public void setIdPregunta(int idPregunta) { this.idPregunta = idPregunta; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public ComunidadPregunta getPregunta() { return pregunta; }
    public void setPregunta(ComunidadPregunta pregunta) { this.pregunta = pregunta; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
