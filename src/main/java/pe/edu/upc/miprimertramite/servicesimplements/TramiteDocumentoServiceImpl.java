package pe.edu.upc.miprimertramite.servicesimplements;

import pe.edu.upc.miprimertramite.entities.TramiteDocumento;
import pe.edu.upc.miprimertramite.repositories.ITramiteDocumentoRepository;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramiteDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TramiteDocumentoServiceImpl implements ITramiteDocumentoService {

    @Autowired
    private ITramiteDocumentoRepository tramiteDocumentoRepository;

    @Override
    public TramiteDocumento save(TramiteDocumento documento) {
        return tramiteDocumentoRepository.save(documento);
    }

    @Override
    public List<TramiteDocumento> list() {
        return tramiteDocumentoRepository.findAll();
    }

    @Override
    public TramiteDocumento findById(int id) {
        return tramiteDocumentoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        tramiteDocumentoRepository.deleteById(id);
    }

    @Override
    public List<TramiteDocumento> findByTramiteId(int idTramite) {
        return tramiteDocumentoRepository.findByTramiteId(idTramite);
    }

    @Override
    public Long countRequiredDocumentsByTramiteId(int idTramite) {
        return tramiteDocumentoRepository.countRequiredDocumentsByTramiteId(idTramite);
    }
}
