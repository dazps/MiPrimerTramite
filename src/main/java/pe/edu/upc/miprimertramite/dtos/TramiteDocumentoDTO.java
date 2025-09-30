package pe.edu.upc.miprimertramite.dtos;

import pe.edu.upc.miprimertramite.entities.Tramite;

public class TramiteDocumentoDTO {

    private int idDocumento;
    private String nombre;
    private Boolean esOpcional;
    private Tramite tramite;

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
