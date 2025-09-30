package pe.edu.upc.miprimertramite.dtos;

public class TramiteDocumentoDTO {
    private int idDocumento;
    private int idTramite;
    private String nombre;
    private boolean esOpcional;

    public TramiteDocumentoDTO() {}

    public TramiteDocumentoDTO(int idDocumento, int idTramite, String nombre, boolean esOpcional) {
        this.idDocumento = idDocumento;
        this.idTramite = idTramite;
        this.nombre = nombre;
        this.esOpcional = esOpcional;
    }

    // Getters y Setters
    public int getIdDocumento() { return idDocumento; }
    public void setIdDocumento(int idDocumento) { this.idDocumento = idDocumento; }

    public int getIdTramite() { return idTramite; }
    public void setIdTramite(int idTramite) { this.idTramite = idTramite; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public boolean isEsOpcional() { return esOpcional; }
    public void setEsOpcional(boolean esOpcional) { this.esOpcional = esOpcional; }
}
