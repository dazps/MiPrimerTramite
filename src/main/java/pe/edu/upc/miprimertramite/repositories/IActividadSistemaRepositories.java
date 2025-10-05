package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.ActividadSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActividadSistemaRepositories extends JpaRepository<ActividadSistema, Integer> {

    @Query(value = "SELECT * FROM actividad_sistema WHERE id_usuario = ?1 ORDER BY fecha DESC LIMIT 10", nativeQuery = true)
    List<ActividadSistema> findLatest10ByUsuarioId(int idUsuario);

    @Query(value = "SELECT COUNT(*) FROM actividad_sistema WHERE id_usuario = ?1 AND tipo_actividad = ?2", nativeQuery = true)
    Long countByUsuarioAndTipo(int idUsuario, String tipoActividad);
}