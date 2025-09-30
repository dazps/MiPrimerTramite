package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.TipoNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoNotificacionRepository extends JpaRepository<TipoNotificacion, Integer> {

    @Query(value = "SELECT * FROM Tipo_Notificaciones WHERE Nombre = ?1", nativeQuery = true)
    TipoNotificacion findByNombre(String nombre);
}
