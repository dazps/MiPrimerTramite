package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITramiteRepositories extends JpaRepository<Tramite, Integer> {

    @Query(value = "SELECT * FROM Tramites ORDER BY Popularidad DESC LIMIT 10", nativeQuery = true)
    List<Tramite> findTop10ByPopularidad();

    @Query(value = "SELECT t.* FROM Tramites t JOIN Valoraciones_Tramites v ON t.ID_Tramite = v.ID_Tramite WHERE v.Puntuacion >= ?1", nativeQuery = true)
    List<Tramite> findByMinPuntuacion(int minPuntuacion);

    @Query(value = "SELECT AVG(v.Puntuacion) FROM Valoraciones_Tramites v WHERE v.ID_Tramite = ?1", nativeQuery = true)
    Double findAveragePuntuacionByTramiteId(int idTramite);
}
