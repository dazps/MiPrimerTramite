package pe.edu.upc.miprimertramite.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.miprimertramite.dtos.ValoracionTramiteDTO;
import pe.edu.upc.miprimertramite.entities.ValoracionTramite;
import pe.edu.upc.miprimertramite.servicesinterfaces.IValoracionTramiteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/valoraciontramite")
public class ValoracionTramiteController {

    @Autowired
    private IValoracionTramiteService service;

    @GetMapping
    public List<ValoracionTramiteDTO> listar() {
        return service.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ValoracionTramiteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ValoracionTramiteDTO dto) {
        ModelMapper m = new ModelMapper();
        ValoracionTramite vt = m.map(dto, ValoracionTramite.class);
        service.insert(vt);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        ValoracionTramite vt = service.listId(id);
        if (vt == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ValoracionTramiteDTO dto = m.map(vt, ValoracionTramiteDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ValoracionTramiteDTO dto) {
        ModelMapper m = new ModelMapper();
        ValoracionTramite vt = m.map(dto, ValoracionTramite.class);

        ValoracionTramite existente = service.listId(vt.getIdValoracion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + vt.getIdValoracion());
        }

        service.update(vt);
        return ResponseEntity.ok("Registro con ID " + vt.getIdValoracion() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        ValoracionTramite vt = service.listId(id);
        if (vt == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    // Endpoint: GET /valoraciontramite/comentario?text=palabra
    @GetMapping("/comentario")
    public List<ValoracionTramiteDTO> buscarPorComentario(@RequestParam("text") String comentario) {

        List<ValoracionTramite> valoraciones = service.searchByComment(comentario);

        ModelMapper m = new ModelMapper();
        return valoraciones.stream()
                .map(v -> m.map(v, ValoracionTramiteDTO.class))
                .collect(Collectors.toList());
    }

    // Endpoint: GET /valoraciontramite/rango?min=1&max=5
    @GetMapping("/rango")
    public List<ValoracionTramiteDTO> buscarPorRangoCalificacion(
            @RequestParam("min") int min,
            @RequestParam("max") int max) {

        List<ValoracionTramite> valoraciones = service.searchByRatingRange(min, max);

        ModelMapper m = new ModelMapper();
        return valoraciones.stream()
                .map(v -> m.map(v, ValoracionTramiteDTO.class))
                .collect(Collectors.toList());
    }
}

