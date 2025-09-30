package pe.edu.upc.miprimertramite.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tipo_Usuarios")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TipoUsuario")
    private int idTipoUsuario;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "Descripcion", length = 150)
    private String descripcion;

    @OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    public TipoUsuario() {}

    public TipoUsuario(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdTipoUsuario() { return idTipoUsuario; }
    public void setIdTipoUsuario(int idTipoUsuario) { this.idTipoUsuario = idTipoUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }
}
