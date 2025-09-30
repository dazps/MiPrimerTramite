package pe.edu.upc.miprimertramite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.miprimertramite.entities.TramitePaso;

import java.util.List;

@Repository
public interface ITramitePasoRepositories extends JpaRepository<TramitePaso, Integer> {

    @Query("SELECT tp FROM TramitePaso tp WHERE tp.descripcionPaso LIKE %:desc%")
    public List<TramitePaso> buscarPorDescripcion(@Param("desc") String descripcion);

    public List<TramitePaso> findByTramiteIdTramiteOrderByOrdenPasoAsc(int idTramite);

    @Query("SELECT COUNT(tp) FROM TramitePaso tp WHERE tp.tramite.idTramite = :idTramite")
    public Long contarPasosPorTramite(@Param("idTramite") int idTramite);
}


