package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.TramitePaso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITramitePasoRepository extends JpaRepository<TramitePaso, Integer> {

    @Query(value = "SELECT * FROM Tramite_Pasos WHERE ID_Tram = ?1", nativeQuery = true)
    List<TramitePaso> findByTramiteId(int idTramite);

    @Query(value = "SELECT * FROM Tramite_Pasos WHERE ID_Tram = ?1 ORDER BY Orden ASC", nativeQuery = true)
    List<TramitePaso> findByTramiteIdOrdered(int idTramite);
}
