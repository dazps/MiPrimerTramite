package pe.edu.upc.miprimertramite.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.miprimertramite.entities.ValoracionTramite;
import pe.edu.upc.miprimertramite.repositories.IValoracionTramiteRepositories;
import pe.edu.upc.miprimertramite.servicesinterfaces.IValoracionTramiteService;

import java.util.List;

@Service
public class ValoracionTramiteServiceImplement implements IValoracionTramiteService {

    @Autowired
    private IValoracionTramiteRepositories repository;

    @Override
    public List<ValoracionTramite> list() {
        return repository.findAll();
    }

    @Override
    public void insert(ValoracionTramite valoracion) {
        repository.save(valoracion);
    }

    @Override
    public ValoracionTramite listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(ValoracionTramite valoracion) {
        repository.save(valoracion);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<ValoracionTramite> searchByComment(String comentario) {
        // Delega la búsqueda de comentario al repositorio
        return repository.buscarPorComentario(comentario);
    }

    @Override
    public List<ValoracionTramite> searchByRatingRange(int min, int max) {
        return repository.buscarPorRangoCalificacion(min, max);
    }

}


