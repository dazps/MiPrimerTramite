package pe.edu.upc.miprimertramite.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.miprimertramite.entities.TramitePaso;
import pe.edu.upc.miprimertramite.repositories.ITramitePasoRepositories;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramitePasoService;

import java.util.List;

@Service
public class TramitePasoServiceImplement implements ITramitePasoService {

    @Autowired
    private ITramitePasoRepositories repository;

    @Override
    public List<TramitePaso> list() {
        return repository.findAll();
    }

    @Override
    public void insert(TramitePaso paso) {
        repository.save(paso);
    }

    @Override
    public TramitePaso listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(TramitePaso paso) {
        repository.save(paso);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    // Metodo para buscar pasos por descripción, usando el query personalizado
    @Override
    public List<TramitePaso> searchDescription(String descriptionPaso) {
        return repository.buscarPorDescripcion(descriptionPaso);
    }

    // Metodo para listar pasos de un trámite por ID, ordenados
    @Override
    public List<TramitePaso> listByTramiteId(int idTramite) {
        return repository.findByTramiteIdTramiteOrderByOrdenPasoAsc(idTramite);
    }

    // Metodo para contar pasos por trámite por ID
    @Override
    public int countStepsByTramiteId(int idTramite) {
        // Se convierte de Long (repositorio) a int (interfaz de servicio)
        Long count = repository.contarPasosPorTramite(idTramite);
        return count != null ? count.intValue() : 0;
    }
}