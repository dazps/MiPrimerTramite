package pe.edu.upc.miprimertramite.servicesimplementations;

import pe.edu.upc.miprimertramite.entities.ValoracionTramite;
import pe.edu.upc.miprimertramite.repositories.IValoracionTramiteRepository;
import pe.edu.upc.miprimertramite.servicesinterfaces.IValoracionTramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionTramiteServiceImpl implements IValoracionTramiteService {

    @Autowired
    private IValoracionTramiteRepository valoracionTramiteRepository;

    @Override
    public ValoracionTramite save(ValoracionTramite valoracion) {
        return valoracionTramiteRepository.save(valoracion);
    }

    @Override
    public List<ValoracionTramite> list() {
        return valoracionTramiteRepository.findAll();
    }

    @Override
    public ValoracionTramite findById(int id) {
        return valoracionTramiteRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        valoracionTramiteRepository.deleteById(id);
    }

    @Override
    public List<ValoracionTramite> findByTramiteId(int idTramite) {
        return valoracionTramiteRepository.findByTramiteId(idTramite);
    }

    @Override
    public Double findAveragePuntuacionByTramiteId(int idTramite) {
        return valoracionTramiteRepository.findAveragePuntuacionByTramiteId(idTramite);
    }

    @Override
    public Long countByTramiteId(int idTramite) {
        return valoracionTramiteRepository.countByTramiteId(idTramite);
    }
}
