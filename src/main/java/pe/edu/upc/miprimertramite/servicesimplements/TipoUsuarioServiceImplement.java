package pe.edu.upc.miprimertramite.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.miprimertramite.entities.TipoUsuario;
import pe.edu.upc.miprimertramite.repositories.ITipoUsuarioRepositories;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITipoUsuarioService;

import java.util.List;

@Service
public class TipoUsuarioServiceImplement implements ITipoUsuarioService {

    @Autowired
    private ITipoUsuarioRepositories tipoUsuarioRepository;

    @Override
    public List<TipoUsuario> list() {
        return tipoUsuarioRepository.findAll();
    }

    @Override
    public void insert(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public TipoUsuario listId(int id) {
        // Usa findById y orElse para manejar el caso de no encontrar el ID
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void update(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public void delete(int id) {
        tipoUsuarioRepository.deleteById(id);
    }

    @Override
    public List<TipoUsuario> searchName(String nameTipo) {
        // Conecta el metodo del servicio con el query del repositorio
        return tipoUsuarioRepository.buscarPorNombre(nameTipo);
    }

    @Override
    public List<String[]> countUsersByTipo() {
        List<Object[]> results = tipoUsuarioRepository.countUsersByTipo();
        return results.stream()
                .map(row -> new String[]{
                        (String) row[0],         // nombreTipo (String)
                        row[1].toString()        // COUNT (Long), convertido a String
                })
                .toList();
    }

}