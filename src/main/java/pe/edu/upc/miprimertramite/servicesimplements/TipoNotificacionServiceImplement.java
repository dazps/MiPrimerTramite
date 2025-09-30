package pe.edu.upc.miprimertramite.servicesimplementations;

import pe.edu.upc.miprimertramite.entities.TipoNotificacion;
import pe.edu.upc.miprimertramite.repositories.ITipoNotificacionRepository;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITipoNotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoNotificacionServiceImpl implements ITipoNotificacionService {

    @Autowired
    private ITipoNotificacionRepository tipoNotificacionRepository;

    @Override
    public TipoNotificacion save(TipoNotificacion tipo) {
        return tipoNotificacionRepository.save(tipo);
    }

    @Override
    public List<TipoNotificacion> list() {
        return tipoNotificacionRepository.findAll();
    }

    @Override
    public TipoNotificacion findById(int id) {
        return tipoNotificacionRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        tipoNotificacionRepository.deleteById(id);
    }

    @Override
    public TipoNotificacion findByNombre(String nombre) {
        return tipoNotificacionRepository.findByNombre(nombre);
    }
}
