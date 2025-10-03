package pe.edu.upc.miprimertramite.servicesimplements;

import pe.edu.upc.miprimertramite.entities.ActividadSistema;
import pe.edu.upc.miprimertramite.repositories.IActividadSistemaRepositories;
import pe.edu.upc.miprimertramite.servicesinterfaces.IActividadSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadSistemaServiceImplement implements IActividadSistemaService {

    @Autowired
    private IActividadSistemaRepositories actividadSistemaRepository;

    @Override
    public ActividadSistema save(ActividadSistema actividad) {
        return actividadSistemaRepository.save(actividad);
    }

    @Override
    public List<ActividadSistema> list() {
        return actividadSistemaRepository.findAll();
    }

    @Override
    public ActividadSistema findById(int id) {
        return actividadSistemaRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        actividadSistemaRepository.deleteById(id);
    }

    @Override
    public List<ActividadSistema> findLatest10ByUsuarioId(int idUsuario) {
        return actividadSistemaRepository.findLatest10ByUsuarioId(idUsuario);
    }

    @Override
    public Long countByUsuarioAndTipo(int idUsuario, String tipoActividad) {
        return actividadSistemaRepository.countByUsuarioAndTipo(idUsuario, tipoActividad);
    }
}
