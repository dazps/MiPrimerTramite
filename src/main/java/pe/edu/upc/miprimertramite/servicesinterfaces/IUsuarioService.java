package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.Usuario;
import java.util.List;

public interface IUsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> list();
    Usuario findById(int id);
    void delete(int id);
    Usuario findByEmail(String email);
    List<Usuario> findByTipoUsuarioNombre(String nombreTipo);
    List<Usuario> findByTipoUsuarioId(int idTipoUsuario);
}
