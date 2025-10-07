package pe.edu.upc.miprimertramite.servicesimplements;

import pe.edu.upc.miprimertramite.entities.TramiteDocumento;
import pe.edu.upc.miprimertramite.repositories.ITramiteDocumentoRepositories;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramiteDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TramiteDocumentoServiceImplement implements ITramiteDocumentoService {

    @Autowired
    private ITramiteDocumentoRepositories repository;

    @Override
    public TramiteDocumento save(TramiteDocumento documento) {
        return repository.save(documento);
    }

    @Override
    public List<TramiteDocumento> list() {
        return repository.findAll();
    }

    @Override
    public TramiteDocumento findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<TramiteDocumento> findByTramiteId(int idTramite) {
        return repository.findByTramiteId(idTramite);
    }

    @Override
    public Long countRequiredDocumentsByTramiteId(int idTramite) {
        return repository.countRequiredDocumentsByTramiteId(idTramite);
    }
}