package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.TipoNotificacion;

import java.util.List;

public interface ITipoNotificacionService {
    TipoNotificacion save(TipoNotificacion tipo);
    List<TipoNotificacion> list();
    TipoNotificacion findById(int id);
    void delete(int id);
    TipoNotificacion findByNombre(String nombre);
}
