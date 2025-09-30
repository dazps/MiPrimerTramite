package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.TipoUsuario;
import java.util.List;

public interface ITipoUsuarioService {
    TipoUsuario save(TipoUsuario tipo);
    List<TipoUsuario> list();
    TipoUsuario findById(int id);
    void delete(int id);
    TipoUsuario findByNombre(String nombre);
    List<Usuario> findUsuariosByTipoNombre(String nombreTipo);
}
