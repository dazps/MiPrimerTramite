package pe.edu.upc.miprimertramite.repositories;

import pe.edu.upc.miprimertramite.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificacionRepositories extends JpaRepository<Notificacion, Integer> {

    @Query(value = "SELECT * FROM Notificaciones WHERE ID_Usuario = ?1 AND Enviado = FALSE", nativeQuery = true)
    List<Notificacion> findPendingByUsuarioId(int idUsuario);

    @Query(value = "UPDATE Notificaciones SET Enviado = TRUE WHERE ID_Notificacion = ?1 RETURNING *", nativeQuery = true)
    Notificacion markAsSent(int idNotificacion);
}
