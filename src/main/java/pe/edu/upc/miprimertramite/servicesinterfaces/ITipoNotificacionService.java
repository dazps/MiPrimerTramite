package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.TipoNotificacion;

public interface ITipoNotificacionService {
    TipoNotificacion save(TipoNotificacion tipo);
    List<TipoNotificacion> list();
    TipoNotificacion findById(int id);
    void delete(int id);
    TipoNotificacion findByNombre(String nombre);
}
