package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.TipoUsuarioDTO;
import pe.edu.upc.miprimertramite.entities.TipoUsuario;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipos-usuario")
public class TipoUsuarioController {

    @Autowired
    private ITipoUsuarioService tipoUsuarioService;

    @PostMapping
    public ResponseEntity<TipoUsuarioDTO> create(@RequestBody TipoUsuarioDTO dto) {
        TipoUsuario tipo = new TipoUsuario();
        tipo.setNombre(dto.getNombre());
        tipo.setDescripcion(dto.getDescripcion());

        TipoUsuario saved = tipoUsuarioService.save(tipo);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuarioDTO>> getAll() {
        List<TipoUsuario> tipos = tipoUsuarioService.list();
        List<TipoUsuarioDTO> dtos = tipos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> getById(@PathVariable int id) {
        TipoUsuario tipo = tipoUsuarioService.findById(id);
        if (tipo != null) {
            return new ResponseEntity<>(toDTO(tipo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        tipoUsuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<TipoUsuarioDTO> getByNombre(@PathVariable String nombre) {
        TipoUsuario tipo = tipoUsuarioService.findByNombre(nombre);
        if (tipo != null) {
            return new ResponseEntity<>(toDTO(tipo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/usuarios/{nombreTipo}")
    public ResponseEntity<List<TipoUsuarioDTO>> getUsuariosByTipoNombre(@PathVariable String nombreTipo) {
        List<Usuario> usuarios = tipoUsuarioService.findUsuariosByTipoNombre(nombreTipo);
        // Aquí podrías devolver una lista de UsuarioDTO si lo necesitas, pero por ahora solo mostramos el tipo.
        // Si quieres listar usuarios, crea un endpoint en UsuarioController.
        return new ResponseEntity<>(HttpStatus.OK); // Placeholder - ajusta según necesidad
    }

    private TipoUsuarioDTO toDTO(TipoUsuario entidad) {
        return new TipoUsuarioDTO(
                entidad.getIdTipoUsuario(),
                entidad.getNombre(),
                entidad.getDescripcion()
        );
    }
}
