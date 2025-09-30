package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tramite_Pasos")
public class TramitePaso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Paso")
    private int idPaso;

    @Column(name = "ID_Tram", nullable = false)
    private int idTram;

    @Column(name = "Orden", nullable = false)
    private int orden;

    @Column(name = "Titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "Descripc", columnDefinition = "text")
    private String descripc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Tram", insertable = false, updatable = false)
    private Tramite tramite;

    @OneToMany(mappedBy = "paso", fetch = FetchType.LAZY)
    private List<UsuarioTramiteProgreso> progresos;

    public TramitePaso() {}

    public TramitePaso(int idTram, int orden, String titulo, String descripc) {
        this.idTram = idTram;
        this.orden = orden;
        this.titulo = titulo;
        this.descripc = descripc;
    }

    public int getIdPaso() { return idPaso; }
    public void setIdPaso(int idPaso) { this.idPaso = idPaso; }

    public int getIdTram() { return idTram; }
    public void setIdTram(int idTram) { this.idTram = idTram; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripc() { return descripc; }
    public void setDescripc(String descripc) { this.descripc = descripc; }

    public Tramite getTramite() { return tramite; }
    public void setTramite(Tramite tramite) { this.tramite = tramite; }

    public List<UsuarioTramiteProgreso> getProgresos() { return progresos; }
    public void setProgresos(List<UsuarioTramiteProgreso> progresos) { this.progresos = progresos; }
}
