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
    private IActividadSistemaRepositories repository;

    @Override
    public ActividadSistema save(ActividadSistema actividad) {
        return repository.save(actividad);
    }

    @Override
    public List<ActividadSistema> list() {
        return repository.findAll();
    }

    @Override
    public ActividadSistema findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<ActividadSistema> findLatest10ByUsuarioId(int idUsuario) {
        return repository.findLatest10ByUsuarioId(idUsuario);
    }

    @Override
    public Long countByUsuarioAndTipo(int idUsuario, String tipoActividad) {
        return repository.countByUsuarioAndTipo(idUsuario, tipoActividad);
    }
}