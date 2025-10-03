package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.UsuarioFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioFavoritoRepositories extends JpaRepository<UsuarioFavorito, Integer> {

    @Query(value = "SELECT * FROM UsuarioFavorito WHERE idUsuario = ?1", nativeQuery = true)
    List<UsuarioFavorito> findByUsuarioId(int idUsuario);

    @Query(value = "SELECT COUNT(*) FROM UsuarioFavorito WHERE idTramite = ?1", nativeQuery = true)
    Long countByTramiteId(int idTramite);

    @Query(value = "SELECT * FROM UsuarioFavorito WHERE idUsuario = ?1 AND idTramite = ?2", nativeQuery = true)
    UsuarioFavorito findByUsuarioAndTramite(int idUsuario, int idTramite);
}
