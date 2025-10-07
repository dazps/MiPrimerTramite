package pe.edu.upc.miprimertramite.servicesimplements;

import pe.edu.upc.miprimertramite.entities.UsuarioFavorito;
import pe.edu.upc.miprimertramite.repositories.IUsuarioFavoritoRepositories;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioFavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioFavoritoServiceImplement implements IUsuarioFavoritoService {

    @Autowired
    private IUsuarioFavoritoRepositories repository;

    @Override
    public UsuarioFavorito save(UsuarioFavorito favorito) {
        return repository.save(favorito);
    }

    @Override
    public List<UsuarioFavorito> list() {
        return repository.findAll();
    }

    @Override
    public UsuarioFavorito findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<UsuarioFavorito> findByUsuarioId(int idUsuario) {
        return repository.findByUsuarioId(idUsuario);
    }

    @Override
    public Long countByTramiteId(int idTramite) {
        return repository.countByTramiteId(idTramite);
    }

    @Override
    public UsuarioFavorito findByUsuarioAndTramite(int idUsuario, int idTramite) {
        return repository.findByUsuarioAndTramite(idUsuario, idTramite);
    }
}