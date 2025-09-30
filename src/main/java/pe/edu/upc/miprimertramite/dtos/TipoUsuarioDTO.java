package pe.edu.upc.miprimertramite.dtos;

public class TipoUsuarioDTO {
    private int idTipoUsuario;
    private String nombre;
    private String descripcion;

    public TipoUsuarioDTO() {}

    public TipoUsuarioDTO(int idTipoUsuario, String nombre, String descripcion) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdTipoUsuario() { return idTipoUsuario; }
    public void setIdTipoUsuario(int idTipoUsuario) { this.idTipoUsuario = idTipoUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
