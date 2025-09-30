package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.ComunidadPregunta;
import java.util.List;

public interface IComunidadPreguntaService {
    ComunidadPregunta save(ComunidadPregunta pregunta);
    List<ComunidadPregunta> list();
    ComunidadPregunta findById(int id);
    void delete(int id);
    List<ComunidadPregunta> findByUsuarioId(int idUsuario);
    List<ComunidadPregunta> findLatest5();
}
