package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.UsuarioFavorito;
import java.util.List;

public interface IUsuarioFavoritoService {
    UsuarioFavorito save(UsuarioFavorito favorito);
    List<UsuarioFavorito> list();
    UsuarioFavorito findById(int id);
    void delete(int id);
    List<UsuarioFavorito> findByUsuarioId(int idUsuario);
    Long countByTramiteId(int idTramite);
    UsuarioFavorito findByUsuarioAndTramite(int idUsuario, int idTramite);
}
