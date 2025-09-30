package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.Notificacion;
import java.util.List;

public interface INotificacionService {
    Notificacion save(Notificacion notificacion);
    List<Notificacion> list();
    Notificacion findById(int id);
    void delete(int id);
    List<Notificacion> findPendingByUsuarioId(int idUsuario);
    Notificacion markAsSent(int idNotificacion);
}
