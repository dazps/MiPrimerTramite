package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.ValoracionTramite;
import java.util.List;

public interface IValoracionTramiteService {
    ValoracionTramite save(ValoracionTramite valoracion);
    List<ValoracionTramite> list();
    ValoracionTramite findById(int id);
    void delete(int id);
    List<ValoracionTramite> findByTramiteId(int idTramite);
    Double findAveragePuntuacionByTramiteId(int idTramite);
    Long countByTramiteId(int idTramite);
}
