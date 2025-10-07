package pe.edu.upc.miprimertramite.dtos;

public class TramiteDocumentoDTO {

    private int idDocumento;
    private String nombre;
    private Boolean esOpcional;
    private int idTramite;

    public TramiteDocumentoDTO() {

    }

    public TramiteDocumentoDTO(int idDocumento, String nombre, Boolean esOpcional, int idTramite) {
        this.idDocumento = idDocumento;
        this.nombre = nombre;
        this.esOpcional = esOpcional;
        this.idTramite = idTramite;
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

    public int getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(int idTramite) {
        this.idTramite = idTramite;
    }
}