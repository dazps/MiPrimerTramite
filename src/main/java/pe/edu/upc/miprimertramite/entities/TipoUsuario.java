package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoUsuario")

public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipo;

    @Column(name = "nombreTipo", nullable = false, length = 100)
    private String nombreTipo;

    @Column(name = "descripcionTipo", nullable = false, length = 200)
    private String descripcionTipo;

    public TipoUsuario() {
    }

    public TipoUsuario(int idTipo, String nombreTipo, String descripcionTipo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
        this.descripcionTipo = descripcionTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

}
