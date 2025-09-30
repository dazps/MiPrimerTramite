package pe.edu.upc.miprimertramite.servicesinterfaces;

import pe.edu.upc.miprimertramite.entities.ValoracionTramite;
import java.util.List;

public interface IValoracionTramiteService {
    public List<ValoracionTramite> list();
    public void insert(ValoracionTramite v);
    public ValoracionTramite listId(int id);
    public void update(ValoracionTramite v);
    public void delete(int id);
    public List<ValoracionTramite> searchByComment(String comentario);
    public List<ValoracionTramite> searchByRatingRange(int min, int max);
}

