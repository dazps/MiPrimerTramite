package pe.edu.upc.miprimertramite.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.miprimertramite.dtos.TramitePasoDTO;
import pe.edu.upc.miprimertramite.entities.TramitePaso;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramitePasoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tramitepaso")
public class TramitePasoController {

    @Autowired
    private ITramitePasoService service;

    @GetMapping
    public List<TramitePasoDTO> listar() {
        return service.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TramitePasoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody TramitePasoDTO dto) {
        ModelMapper m = new ModelMapper();
        TramitePaso tp = m.map(dto, TramitePaso.class);
        service.insert(tp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        TramitePaso tp = service.listId(id);
        if (tp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TramitePasoDTO dto = m.map(tp, TramitePasoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TramitePasoDTO dto) {
        ModelMapper m = new ModelMapper();
        TramitePaso tp = m.map(dto, TramitePaso.class);

        TramitePaso existente = service.listId(tp.getIdPaso());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + tp.getIdPaso());
        }

        service.update(tp);
        return ResponseEntity.ok("Registro con ID " + tp.getIdPaso() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        TramitePaso tp = service.listId(id);
        if (tp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    // Endpoint para buscar por descripción
    @GetMapping("/buscar")
    public List<TramitePasoDTO> buscarPorDescripcion(@RequestParam String desc) {
        return service.searchDescription(desc).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TramitePasoDTO.class);
        }).collect(Collectors.toList());
    }

    // Endpoint para listar pasos de un trámite por ID y ordenados
    @GetMapping("/tramite/{idTramite}")
    public List<TramitePasoDTO> listarPorTramite(@PathVariable("idTramite") Integer idTramite) {
        return service.listByTramiteId(idTramite).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TramitePasoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/contar/{idTramite}")
    public ResponseEntity<Integer> contarPasosPorTramite(@PathVariable("idTramite") Integer idTramite) {
        int count = service.countStepsByTramiteId(idTramite);
        return ResponseEntity.ok(count);
    }
}



