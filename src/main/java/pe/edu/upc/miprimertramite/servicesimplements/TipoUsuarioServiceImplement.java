package pe.edu.upc.miprimertramite.servicesimplementations;

import pe.edu.upc.miprimertramite.entities.TipoUsuario;
import pe.edu.upc.miprimertramite.repositories.ITipoUsuarioRepository;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements ITipoUsuarioService {

    @Autowired
    private ITipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public TipoUsuario save(TipoUsuario tipo) {
        return tipoUsuarioRepository.save(tipo);
    }

    @Override
    public List<TipoUsuario> list() {
        return tipoUsuarioRepository.findAll();
    }

    @Override
    public TipoUsuario findById(int id) {
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        tipoUsuarioRepository.deleteById(id);
    }

    @Override
    public TipoUsuario findByNombre(String nombre) {
        return tipoUsuarioRepository.findByNombre(nombre);
    }

    @Override
    public List<Usuario> findUsuariosByTipoNombre(String nombreTipo) {
        return tipoUsuarioRepository.findUsuariosByTipoNombre(nombreTipo);
    }
}
