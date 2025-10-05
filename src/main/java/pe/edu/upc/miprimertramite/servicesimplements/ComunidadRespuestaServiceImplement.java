package pe.edu.upc.miprimertramite.servicesimplements;

import pe.edu.upc.miprimertramite.entities.ComunidadRespuesta;
import pe.edu.upc.miprimertramite.repositories.IComunidadRespuestaRepositories;
import pe.edu.upc.miprimertramite.servicesinterfaces.IComunidadRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunidadRespuestaServiceImplement implements IComunidadRespuestaService {

    @Autowired
    private IComunidadRespuestaRepositories comunidadRespuestaRepository;

    @Override
    public ComunidadRespuesta save(ComunidadRespuesta respuesta) {
        return comunidadRespuestaRepository.save(respuesta);
    }

    @Override
    public List<ComunidadRespuesta> list() {
        return comunidadRespuestaRepository.findAll();
    }

    @Override
    public ComunidadRespuesta findById(int id) {
        return comunidadRespuestaRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        comunidadRespuestaRepository.deleteById(id);
    }

    @Override
    public List<ComunidadRespuesta> findByPreguntaId(int idPregunta) {
        return comunidadRespuestaRepository.findByPreguntaId(idPregunta);
    }

    @Override
    public Long countByPreguntaId(int idPregunta) {
        return comunidadRespuestaRepository.countByPreguntaId(idPregunta);
    }
}
