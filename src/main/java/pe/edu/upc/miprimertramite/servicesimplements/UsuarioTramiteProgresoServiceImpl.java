package pe.edu.upc.miprimertramite.servicesimplements;

import pe.edu.upc.miprimertramite.entities.UsuarioTramiteProgreso;
import pe.edu.upc.miprimertramite.repositories.IUsuarioTramiteProgresoRepository;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioTramiteProgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioTramiteProgresoServiceImpl implements IUsuarioTramiteProgresoService {

    @Autowired
    private IUsuarioTramiteProgresoRepository usuarioTramiteProgresoRepository;

    @Override
    public UsuarioTramiteProgreso save(UsuarioTramiteProgreso progreso) {
        return usuarioTramiteProgresoRepository.save(progreso);
    }

    @Override
    public List<UsuarioTramiteProgreso> list() {
        return usuarioTramiteProgresoRepository.findAll();
    }

    @Override
    public UsuarioTramiteProgreso findById(int id) {
        return usuarioTramiteProgresoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        usuarioTramiteProgresoRepository.deleteById(id);
    }

    @Override
    public List<UsuarioTramiteProgreso> findByUsuarioAndTramite(int idUsuario, int idTramite) {
        return usuarioTramiteProgresoRepository.findByUsuarioAndTramite(idUsuario, idTramite);
    }

    @Override
    public Long countCompletedStepsByUsuarioAndTramite(int idUsuario, int idTramite) {
        return usuarioTramiteProgresoRepository.countCompletedStepsByUsuarioAndTramite(idUsuario, idTramite);
    }

    @Override
    public UsuarioTramiteProgreso findNextStep(int idUsuario, int idTramite) {
        return usuarioTramiteProgresoRepository.findNextStep(idUsuario, idTramite);
    }
}
