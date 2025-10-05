package pe.edu.upc.miprimertramite.servicesimplements;

import pe.edu.upc.miprimertramite.entities.Notificacion;
import pe.edu.upc.miprimertramite.repositories.INotificacionRepositories;
import pe.edu.upc.miprimertramite.servicesinterfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {

    @Autowired
    private INotificacionRepositories notificacionRepository;

    @Override
    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    @Override
    public List<Notificacion> list() {
        return notificacionRepository.findAll();
    }

    @Override
    public Notificacion findById(int id) {
        return notificacionRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        notificacionRepository.deleteById(id);
    }

    @Override
    public List<Notificacion> findPendingByUsuarioId(int idUsuario) {
        return notificacionRepository.findPendingByUsuarioId(idUsuario);
    }

    @Override
    public Notificacion markAsSent(int idNotificacion) {
        return notificacionRepository.markAsSent(idNotificacion);
    }
}
