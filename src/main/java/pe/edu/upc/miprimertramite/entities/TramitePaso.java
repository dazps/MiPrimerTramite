package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TramitePaso")
public class TramitePaso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaso;

    @ManyToOne
    @JoinColumn(name = "idTramite", nullable = false)
    private Tramite tramite;

    @Column(name = "descripcionPaso", nullable = false, length = 500)
    private String descripcionPaso;

    @Column(name = "orden", nullable = false)
    private int ordenPaso;

    // Constructor vacío
    public TramitePaso() {}

    // Constructor con parámetros
    public TramitePaso(Tramite tramite, String descripcionPaso, int ordenPaso) {
        this.tramite = tramite;
        this.descripcionPaso = descripcionPaso;
        this.ordenPaso = ordenPaso;
    }

    // Getters y Setters
    public int getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(int idPaso) {
        this.idPaso = idPaso;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public String getDescripcionPaso() {
        return descripcionPaso;
    }

    public void setDescripcionPaso(String descripcionPaso) {
        this.descripcionPaso = descripcionPaso;
    }

    public int getOrdenPaso() {
        return ordenPaso;
    }

    public void setOrdenPaso(int ordenPaso) {
        this.ordenPaso = ordenPaso;
    }
}

