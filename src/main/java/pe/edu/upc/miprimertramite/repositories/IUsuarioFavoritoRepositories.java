package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.UsuarioFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioFavoritoRepositories extends JpaRepository<UsuarioFavorito, Integer> {

    @Query(value = "SELECT * FROM usuario_favorito WHERE id_usuario = ?1", nativeQuery = true)
    List<UsuarioFavorito> findByUsuarioId(int idUsuario);

    @Query(value = "SELECT COUNT(*) FROM usuario_favorito WHERE id_tramite = ?1", nativeQuery = true)
    Long countByTramiteId(int idTramite);

    @Query(value = "SELECT * FROM usuario_favorito WHERE id_usuario = ?1 AND id_tramite = ?2", nativeQuery = true)
    UsuarioFavorito findByUsuarioAndTramite(int idUsuario, int idTramite);
}