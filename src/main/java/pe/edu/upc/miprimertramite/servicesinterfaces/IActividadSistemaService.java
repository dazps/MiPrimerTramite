package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.ActividadSistema;
import java.util.List;

public interface IActividadSistemaService {
    ActividadSistema save(ActividadSistema actividad);
    List<ActividadSistema> list();
    ActividadSistema findById(int id);
    void delete(int id);
    List<ActividadSistema> findLatest10ByUsuarioId(int idUsuario);
    Long countByUsuarioAndTipo(int idUsuario, String tipoActividad);
}
