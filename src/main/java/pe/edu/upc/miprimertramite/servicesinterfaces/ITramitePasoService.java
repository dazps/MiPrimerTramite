package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.TramitePaso;
import java.util.List;

public interface ITramitePasoService {
    public List<TramitePaso> list();
    public void insert(TramitePaso t);
    public TramitePaso listId(int id);
    public void update(TramitePaso t);
    public void delete(int id);
    public List<TramitePaso> searchDescription(String descriptionPaso);
    public List<TramitePaso> listByTramiteId(int idTramite);
    public int countStepsByTramiteId(int idTramite);
}
