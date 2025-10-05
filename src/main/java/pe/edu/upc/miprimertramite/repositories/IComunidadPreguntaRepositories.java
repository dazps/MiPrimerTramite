package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.ComunidadPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComunidadPreguntaRepositories extends JpaRepository<ComunidadPregunta, Integer> {

    @Query(value = "SELECT * FROM Comunidad_Preguntas WHERE ID_Usuario = ?1", nativeQuery = true)
    List<ComunidadPregunta> findByUsuarioId(int idUsuario);

    @Query(value = "SELECT * FROM comunidad_preguntas ORDER BY fecha_creacion DESC LIMIT 5", nativeQuery = true)
    List<ComunidadPregunta> findLatest5();
}
