package pe.edu.upc.miprimertramite.servicesimplements;

import pe.edu.upc.miprimertramite.entities.Usuario;
import pe.edu.upc.miprimertramite.repositories.IUsuarioRepositories;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepositories usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> findByTipoUsuarioNombre(String nombreTipo) {
        return usuarioRepository.findByTipoUsuarioNombre(nombreTipo);
    }

    @Override
    public List<Usuario> findByTipoUsuarioId(int idTipoUsuario) {
        return usuarioRepository.findByTipoUsuarioId(idTipoUsuario);
    }
}
