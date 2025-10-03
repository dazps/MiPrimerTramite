package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.ActividadSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActividadSistemaRepositories extends JpaRepository<ActividadSistema, Integer> {

    @Query(value = "SELECT * FROM Actividad_Sistema WHERE ID_Usuario = ?1 ORDER BY Fecha DESC LIMIT 10", nativeQuery = true)
    List<ActividadSistema> findLatest10ByUsuarioId(int idUsuario);

    @Query(value = "SELECT COUNT(*) FROM Actividad_Sistema WHERE ID_Usuario = ?1 AND TipoActividad = ?2", nativeQuery = true)
    Long countByUsuarioAndTipo(int idUsuario, String tipoActividad);
}
