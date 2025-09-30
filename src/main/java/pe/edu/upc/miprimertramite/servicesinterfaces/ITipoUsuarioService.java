package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.TipoUsuario;
import java.util.List;

public interface ITipoUsuarioService {
    public List<TipoUsuario> list();
    public void insert(TipoUsuario t);
    public TipoUsuario listId(int id);
    public void update(TipoUsuario t);
    public void delete(int id);
    public List<TipoUsuario> searchName(String nameTipo);
    public List<String[]> countUsersByTipo();
}
