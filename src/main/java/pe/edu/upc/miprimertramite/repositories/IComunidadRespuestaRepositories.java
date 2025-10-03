package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.ComunidadRespuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComunidadRespuestaRepositories extends JpaRepository<ComunidadRespuesta, Integer> {

    @Query(value = "SELECT * FROM Comunidad_Respuestas WHERE ID_Pregunta = ?1", nativeQuery = true)
    List<ComunidadRespuesta> findByPreguntaId(int idPregunta);

    @Query(value = "SELECT COUNT(*) FROM Comunidad_Respuestas WHERE ID_Pregunta = ?1", nativeQuery = true)
    Long countByPreguntaId(int idPregunta);
}
