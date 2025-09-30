package pe.edu.upc.miprimertramite.dtos;

public class TramitePasoDTO {
    private int idPaso;
    private int idTram;
    private int orden;
    private String titulo;
    private String descripc;

    public TramitePasoDTO() {}

    public TramitePasoDTO(int idPaso, int idTram, int orden, String titulo, String descripc) {
        this.idPaso = idPaso;
        this.idTram = idTram;
        this.orden = orden;
        this.titulo = titulo;
        this.descripc = descripc;
    }

    // Getters y Setters
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
}
