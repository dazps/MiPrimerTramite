package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tramite_Documentos")
public class TramiteDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Documento")
    private int idDocumento;

    @Column(name = "ID_Tramite", nullable = false)
    private int idTramite;

    @Column(name = "Nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "EsOpcional", nullable = false)
    private boolean esOpcional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Tramite", insertable = false, updatable = false)
    private Tramite tramite;

    public TramiteDocumento() {}

    public TramiteDocumento(int idTramite, String nombre, boolean esOpcional) {
        this.idTramite = idTramite;
        this.nombre = nombre;
        this.esOpcional = esOpcional;
    }

    public int getIdDocumento() { return idDocumento; }
    public void setIdDocumento(int idDocumento) { this.idDocumento = idDocumento; }

    public int getIdTramite() { return idTramite; }
    public void setIdTramite(int idTramite) { this.idTramite = idTramite; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public boolean isEsOpcional() { return esOpcional; }
    public void setEsOpcional(boolean esOpcional) { this.esOpcional = esOpcional; }

    public Tramite getTramite() { return tramite; }
    public void setTramite(Tramite tramite) { this.tramite = tramite; }
}
