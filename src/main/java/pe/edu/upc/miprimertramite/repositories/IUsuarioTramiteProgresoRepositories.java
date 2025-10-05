package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.UsuarioTramiteProgreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioTramiteProgresoRepositories extends JpaRepository<UsuarioTramiteProgreso, Integer> {

    @Query(value = "SELECT * FROM Usuario_Tramite_Progreso WHERE ID_Usuario = ?1 AND ID_Tramite = ?2", nativeQuery = true)
    List<UsuarioTramiteProgreso> findByUsuarioAndTramite(int idUsuario, int idTramite);

    @Query(value = "SELECT COUNT(*) FROM Usuario_Tramite_Progreso WHERE ID_Usuario = ?1 AND ID_Tramite = ?2 AND Completado = TRUE", nativeQuery = true)
    Long countCompletedStepsByUsuarioAndTramite(int idUsuario, int idTramite);

    @Query(value = "SELECT * FROM Usuario_Tramite_Progreso WHERE ID_Usuario = ?1 AND ID_Tramite = ?2 AND Completado = FALSE ORDER BY ID_Paso ASC LIMIT 1", nativeQuery = true)
    UsuarioTramiteProgreso findNextStep(int idUsuario, int idTramite);
}
