package pe.edu.upc.miprimertramite.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.miprimertramite.dtos.TipoUsuarioDTO;
import pe.edu.upc.miprimertramite.entities.TipoUsuario;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITipoUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipousuario")
public class TipoUsuarioController {

    @Autowired
    private ITipoUsuarioService service;

    @GetMapping
    public List<TipoUsuarioDTO> listar() {
        return service.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TipoUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody TipoUsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoUsuario tu = m.map(dto, TipoUsuario.class);
        service.insert(tu);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        TipoUsuario tu = service.listId(id);
        if (tu == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TipoUsuarioDTO dto = m.map(tu, TipoUsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TipoUsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoUsuario tu = m.map(dto, TipoUsuario.class);

        TipoUsuario existente = service.listId(dto.getIdTipo());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + tu.getIdTipo());
        }

        service.update(tu);
        return ResponseEntity.ok("Registro con ID " + tu.getIdTipo() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        TipoUsuario tu = service.listId(id);
        if (tu == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    // Nuevo metodo para búsqueda por nombre
    @GetMapping("/buscar")
    public List<TipoUsuarioDTO> buscarPorNombre(@RequestParam String name) {
        return service.searchName(name).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TipoUsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    // URL de uso: GET /tipousuario/buscar?name=Cliente

    // Nuevo metodo para el conteo analítico
    @GetMapping("/conteo")
    public List<String[]> contarUsuariosPorTipo() {
        return service.countUsersByTipo();
    }
    // URL de uso: GET /tipousuario/conteo
    // Devuelve una lista de arrays [nombreTipo, cantidad]
}

