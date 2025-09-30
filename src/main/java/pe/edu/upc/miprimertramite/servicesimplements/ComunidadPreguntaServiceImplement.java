package pe.edu.upc.miprimertramite.servicesimplementations;

import pe.edu.upc.miprimertramite.entities.ComunidadPregunta;
import pe.edu.upc.miprimertramite.repositories.IComunidadPreguntaRepository;
import pe.edu.upc.miprimertramite.servicesinterfaces.IComunidadPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunidadPreguntaServiceImplement implements IComunidadPreguntaService {

    @Autowired
    private IComunidadPreguntaRepository comunidadPreguntaRepository;

    @Override
    public ComunidadPregunta save(ComunidadPregunta pregunta) {
        return comunidadPreguntaRepository.save(pregunta);
    }

    @Override
    public List<ComunidadPregunta> list() {
        return comunidadPreguntaRepository.findAll();
    }

    @Override
    public ComunidadPregunta findById(int id) {
        return comunidadPreguntaRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        comunidadPreguntaRepository.deleteById(id);
    }

    @Override
    public List<ComunidadPregunta> findByUsuarioId(int idUsuario) {
        return comunidadPreguntaRepository.findByUsuarioId(idUsuario);
    }

    @Override
    public List<ComunidadPregunta> findLatest5() {
        return comunidadPreguntaRepository.findLatest5();
    }
}
