package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Tramites")
public class Tramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Tramite")
    private int idTramite;

    @Column(name = "Titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "Descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "Popularidad", nullable = false)
    private int popularidad;

    @Column(name = "ActualizadoEn")
    private LocalDateTime actualizadoEn;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<TramitePaso> pasos;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<ValoracionTramite> valoraciones;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<UsuarioTramiteProgreso> progresos;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<TramiteDocumento> documentos;

    @OneToMany(mappedBy = "tramite", fetch = FetchType.LAZY)
    private List<UsuarioFavorito> favoritos;

    public Tramite() {}

    public Tramite(String titulo, String descripcion, int popularidad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.popularidad = popularidad;
        this.actualizadoEn = LocalDateTime.now();
    }

    public int getIdTramite() { return idTramite; }
    public void setIdTramite(int idTramite) { this.idTramite = idTramite; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getPopularidad() { return popularidad; }
    public void setPopularidad(int popularidad) { this.popularidad = popularidad; }

    public LocalDateTime getActualizadoEn() { return actualizadoEn; }
    public void setActualizadoEn(LocalDateTime actualizadoEn) { this.actualizadoEn = actualizadoEn; }

    public List<TramitePaso> getPasos() { return pasos; }
    public void setPasos(List<TramitePaso> pasos) { this.pasos = pasos; }

    public List<ValoracionTramite> getValoraciones() { return valoraciones; }
    public void setValoraciones(List<ValoracionTramite> valoraciones) { this.valoraciones = valoraciones; }

    public List<UsuarioTramiteProgreso> getProgresos() { return progresos; }
    public void setProgresos(List<UsuarioTramiteProgreso> progresos) { this.progresos = progresos; }

    public List<TramiteDocumento> getDocumentos() { return documentos; }
    public void setDocumentos(List<TramiteDocumento> documentos) { this.documentos = documentos; }

    public List<UsuarioFavorito> getFavoritos() { return favoritos; }
    public void setFavoritos(List<UsuarioFavorito> favoritos) { this.favoritos = favoritos; }
}
