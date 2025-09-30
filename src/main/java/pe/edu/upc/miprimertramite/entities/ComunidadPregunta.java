package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Comunidad_Preguntas")
public class ComunidadPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pregunta")
    private int idPregunta;

    @Column(name = "ID_Usuario", nullable = false)
    private int idUsuario;

    @Column(name = "Titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "Contenido", columnDefinition = "text")
    private String contenido;

    @Column(name = "FechaCreacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "pregunta", fetch = FetchType.LAZY)
    private List<ComunidadRespuesta> respuestas;

    public ComunidadPregunta() {}

    public ComunidadPregunta(int idUsuario, String titulo, String contenido) {
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = LocalDateTime.now();
    }

    public int getIdPregunta() { return idPregunta; }
    public void setIdPregunta(int idPregunta) { this.idPregunta = idPregunta; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<ComunidadRespuesta> getRespuestas() { return respuestas; }
    public void setRespuestas(List<ComunidadRespuesta> respuestas) { this.respuestas = respuestas; }
}
