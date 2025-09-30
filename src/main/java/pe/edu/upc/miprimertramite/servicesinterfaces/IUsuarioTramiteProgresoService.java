package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.UsuarioTramiteProgreso;
import java.util.List;

public interface IUsuarioTramiteProgresoService {
    UsuarioTramiteProgreso save(UsuarioTramiteProgreso progreso);
    List<UsuarioTramiteProgreso> list();
    UsuarioTramiteProgreso findById(int id);
    void delete(int id);
    List<UsuarioTramiteProgreso> findByUsuarioAndTramite(int idUsuario, int idTramite);
    Long countCompletedStepsByUsuarioAndTramite(int idUsuario, int idTramite);
    UsuarioTramiteProgreso findNextStep(int idUsuario, int idTramite);
}
