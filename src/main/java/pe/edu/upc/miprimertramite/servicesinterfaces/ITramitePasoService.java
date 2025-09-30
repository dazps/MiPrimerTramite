package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.TramitePaso;
import java.util.List;

public interface ITramitePasoService {
    TramitePaso save(TramitePaso paso);
    List<TramitePaso> list();
    TramitePaso findById(int id);
    void delete(int id);
    List<TramitePaso> findByTramiteId(int idTramite);
    List<TramitePaso> findByTramiteIdOrdered(int idTramite);
}
