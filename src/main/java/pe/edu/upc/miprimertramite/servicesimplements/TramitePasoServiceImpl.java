package pe.edu.upc.miprimertramite.servicesimplements;

import pe.edu.upc.miprimertramite.entities.TramitePaso;
import pe.edu.upc.miprimertramite.repositories.ITramitePasoRepository;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramitePasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TramitePasoServiceImpl implements ITramitePasoService {

    @Autowired
    private ITramitePasoRepository tramitePasoRepository;

    @Override
    public TramitePaso save(TramitePaso paso) {
        return tramitePasoRepository.save(paso);
    }

    @Override
    public List<TramitePaso> list() {
        return tramitePasoRepository.findAll();
    }

    @Override
    public TramitePaso findById(int id) {
        return tramitePasoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        tramitePasoRepository.deleteById(id);
    }

    @Override
    public List<TramitePaso> findByTramiteId(int idTramite) {
        return tramitePasoRepository.findByTramiteId(idTramite);
    }

    @Override
    public List<TramitePaso> findByTramiteIdOrdered(int idTramite) {
        return tramitePasoRepository.findByTramiteIdOrdered(idTramite);
    }
}
