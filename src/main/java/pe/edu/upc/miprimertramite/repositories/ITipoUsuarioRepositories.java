package pe.edu.upc.miprimertramite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.miprimertramite.entities.TipoUsuario;

import java.util.List;

@Repository
public interface ITipoUsuarioRepositories extends JpaRepository<TipoUsuario, Integer> {

    @Query("SELECT t FROM TipoUsuario t WHERE t.nombreTipo LIKE %:nombre%")
    public List<TipoUsuario> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT t.nombreTipo, COUNT(u.id) FROM TipoUsuario t JOIN Usuario u ON t.idTipo = u.idTipoUsuario.idTipo GROUP BY t.nombreTipo")
    public List<Object[]> countUsersByTipo();

}
