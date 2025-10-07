package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.TramiteDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITramiteDocumentoRepositories extends JpaRepository<TramiteDocumento, Integer> {

    @Query(value = "SELECT * FROM tramite_documento WHERE id_tramite = ?1", nativeQuery = true)
    List<TramiteDocumento> findByTramiteId(int idTramite);

    @Query(value = "SELECT COUNT(*) FROM tramite_documento WHERE id_tramite = ?1 AND es_opcional = FALSE", nativeQuery = true)
    Long countRequiredDocumentsByTramiteId(int idTramite);
}