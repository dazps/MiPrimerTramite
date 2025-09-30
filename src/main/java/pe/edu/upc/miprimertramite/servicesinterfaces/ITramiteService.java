package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.Tramite;
import java.util.List;

public interface ITramiteService {
    Tramite save(Tramite tramite);
    List<Tramite> list();
    Tramite findById(int id);
    void delete(int id);
    List<Tramite> findTop10ByPopularidad();
    List<Tramite> findByMinPuntuacion(int minPuntuacion);
    Double findAveragePuntuacionByTramiteId(int idTramite);
}
