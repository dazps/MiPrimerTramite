package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.TramiteDocumento;
import java.util.List;

public interface ITramiteDocumentoService {
    TramiteDocumento save(TramiteDocumento documento);
    List<TramiteDocumento> list();
    TramiteDocumento findById(int id);
    void delete(int id);
    List<TramiteDocumento> findByTramiteId(int idTramite);
    Long countRequiredDocumentsByTramiteId(int idTramite);
}
