package pe.edu.upc.miprimertramite.servicesimplementations;

import pe.edu.upc.miprimertramite.entities.Tramite;
import pe.edu.upc.miprimertramite.repositories.ITramiteRepository;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TramiteServiceImpl implements ITramiteService {

    @Autowired
    private ITramiteRepository tramiteRepository;

    @Override
    public Tramite save(Tramite tramite) {
        return tramiteRepository.save(tramite);
    }

    @Override
    public List<Tramite> list() {
        return tramiteRepository.findAll();
    }

    @Override
    public Tramite findById(int id) {
        return tramiteRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        tramiteRepository.deleteById(id);
    }

    @Override
    public List<Tramite> findTop10ByPopularidad() {
        return tramiteRepository.findTop10ByPopularidad();
    }

    @Override
    public List<Tramite> findByMinPuntuacion(int minPuntuacion) {
        return tramiteRepository.findByMinPuntuacion(minPuntuacion);
    }

    @Override
    public Double findAveragePuntuacionByTramiteId(int idTramite) {
        return tramiteRepository.findAveragePuntuacionByTramiteId(idTramite);
    }
}
