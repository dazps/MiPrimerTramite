package pe.edu.upc.miprimertramite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.miprimertramite.entities.ValoracionTramite;

import java.util.List;

@Repository
public interface IValoracionTramiteRepositories extends JpaRepository<ValoracionTramite, Integer> {

    @Query("SELECT v FROM ValoracionTramite v WHERE v.comentario LIKE %:comentario%")
    public List<ValoracionTramite> buscarPorComentario(@Param("comentario") String comentario);

    @Query("SELECT v FROM ValoracionTramite v WHERE v.puntuacion >= :min AND v.puntuacion <= :max")
    public List<ValoracionTramite> buscarPorRangoCalificacion(@Param("min") int min, @Param("max") int max);
}

