package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM Usuarios WHERE Email = ?1", nativeQuery = true)
    Usuario findByEmail(String email);

    @Query(value = "SELECT u.* FROM Usuarios u JOIN Tipo_Usuarios t ON u.ID_TipoUsuario = t.ID_TipoUsuario WHERE t.Nombre = ?1", nativeQuery = true)
    List<Usuario> findByTipoUsuarioNombre(String nombreTipo);

    @Query(value = "SELECT * FROM Usuarios WHERE ID_TipoUsuario = ?1", nativeQuery = true)
    List<Usuario> findByTipoUsuarioId(int idTipoUsuario);
}
