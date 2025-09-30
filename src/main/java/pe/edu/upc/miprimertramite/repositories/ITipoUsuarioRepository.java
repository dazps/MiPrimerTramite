package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.miprimertramite.entities.Usuario;

import java.util.List;

@Repository
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

    @Query(value = "SELECT * FROM Tipo_Usuarios WHERE Nombre = ?1", nativeQuery = true)
    TipoUsuario findByNombre(String nombre);

    @Query(value = "SELECT u.* FROM Usuarios u JOIN Tipo_Usuarios t ON u.ID_TipoUsuario = t.ID_TipoUsuario WHERE t.Nombre = ?1", nativeQuery = true)
    List<Usuario> findUsuariosByTipoNombre(String nombreTipo);
}
