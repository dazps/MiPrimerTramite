package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TramiteDocumento")
public class TramiteDocumento {

    @Id
    @GeneratedValue
    private int idDocumento;

    @Column(name = "Nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "EsOpcional", nullable = false)
    private Boolean esOpcional;

    @ManyToOne
    @JoinColumn(name = "idTramite")
    private Tramite tramite;

    public TramiteDocumento() {

    }

    public TramiteDocumento(int idDocumento, String nombre, Boolean esOpcional, Tramite tramite) {
        this.idDocumento = idDocumento;
        this.nombre = nombre;
        this.esOpcional = esOpcional;
        this.tramite = tramite;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEsOpcional() {
        return esOpcional;
    }

    public void setEsOpcional(Boolean esOpcional) {
        this.esOpcional = esOpcional;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }
}
