package pe.edu.upc.miprimertramite.servicesimplementations;

import pe.edu.upc.miprimertramite.entities.UsuarioFavorito;
import pe.edu.upc.miprimertramite.repositories.IUsuarioFavoritoRepository;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioFavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioFavoritoServiceImpl implements IUsuarioFavoritoService {

    @Autowired
    private IUsuarioFavoritoRepository usuarioFavoritoRepository;

    @Override
    public UsuarioFavorito save(UsuarioFavorito favorito) {
        return usuarioFavoritoRepository.save(favorito);
    }

    @Override
    public List<UsuarioFavorito> list() {
        return usuarioFavoritoRepository.findAll();
    }

    @Override
    public UsuarioFavorito findById(int id) {
        return usuarioFavoritoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        usuarioFavoritoRepository.deleteById(id);
    }

    @Override
    public List<UsuarioFavorito> findByUsuarioId(int idUsuario) {
        return usuarioFavoritoRepository.findByUsuarioId(idUsuario);
    }

    @Override
    public Long countByTramiteId(int idTramite) {
        return usuarioFavoritoRepository.countByTramiteId(idTramite);
    }

    @Override
    public UsuarioFavorito findByUsuarioAndTramite(int idUsuario, int idTramite) {
        return usuarioFavoritoRepository.findByUsuarioAndTramite(idUsuario, idTramite);
    }
}
