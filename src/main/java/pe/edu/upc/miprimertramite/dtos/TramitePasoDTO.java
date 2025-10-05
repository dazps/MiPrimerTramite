package pe.edu.upc.miprimertramite.dtos;

public class TramitePasoDTO {
    private int idPaso;
    private int idTramite;
    private String descripcionPaso;
    private int ordenPaso;

    public int getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(int idPaso) {
        this.idPaso = idPaso;
    }

    public int getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(int idTramite) {
        this.idTramite = idTramite;
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

