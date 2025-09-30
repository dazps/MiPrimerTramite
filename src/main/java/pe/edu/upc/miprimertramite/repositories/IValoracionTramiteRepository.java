package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.ValoracionTramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IValoracionTramiteRepository extends JpaRepository<ValoracionTramite, Integer> {

    @Query(value = "SELECT * FROM Valoraciones_Tramites WHERE ID_Tramite = ?1", nativeQuery = true)
    List<ValoracionTramite> findByTramiteId(int idTramite);

    @Query(value = "SELECT AVG(Puntuacion) FROM Valoraciones_Tramites WHERE ID_Tramite = ?1", nativeQuery = true)
    Double findAveragePuntuacionByTramiteId(int idTramite);

    @Query(value = "SELECT COUNT(*) FROM Valoraciones_Tramites WHERE ID_Tramite = ?1", nativeQuery = true)
    Long countByTramiteId(int idTramite);
}
