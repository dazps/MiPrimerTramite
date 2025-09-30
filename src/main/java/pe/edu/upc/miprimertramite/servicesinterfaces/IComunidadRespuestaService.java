package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.ComunidadRespuesta;
import java.util.List;

public interface IComunidadRespuestaService {
    ComunidadRespuesta save(ComunidadRespuesta respuesta);
    List<ComunidadRespuesta> list();
    ComunidadRespuesta findById(int id);
    void delete(int id);
    List<ComunidadRespuesta> findByPreguntaId(int idPregunta);
    Long countByPreguntaId(int idPregunta);
}
