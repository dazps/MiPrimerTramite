package pe.edu.upc.miprimertramite.dtos;

public class TipoNotificacionDTO {
    private int idTipoNotificacion;
    private String nombre;
    private String descripcion;

    public TipoNotificacionDTO() {}

    public TipoNotificacionDTO(int idTipoNotificacion, String nombre, String descripcion) {
        this.idTipoNotificacion = idTipoNotificacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdTipoNotificacion() { return idTipoNotificacion; }
    public void setIdTipoNotificacion(int idTipoNotificacion) { this.idTipoNotificacion = idTipoNotificacion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
