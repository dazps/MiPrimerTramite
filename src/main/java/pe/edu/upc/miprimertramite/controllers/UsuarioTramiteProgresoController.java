package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.UsuarioTramiteProgresoDTO;
import pe.edu.upc.miprimertramite.entities.UsuarioTramiteProgreso;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioTramiteProgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/progresos")
public class UsuarioTramiteProgresoController {

    @Autowired
    private IUsuarioTramiteProgresoService usuarioTramiteProgresoService;

    @PostMapping
    public ResponseEntity<UsuarioTramiteProgresoDTO> create(@RequestBody UsuarioTramiteProgresoDTO dto) {
        UsuarioTramiteProgreso progreso = new UsuarioTramiteProgreso();
        progreso.setIdUsuario(dto.getIdUsuario());
        progreso.setIdTramite(dto.getIdTramite());
        progreso.setIdPaso(dto.getIdPaso());
        progreso.setCompletado(dto.isCompletado());

        UsuarioTramiteProgreso saved = usuarioTramiteProgresoService.save(progreso);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioTramiteProgresoDTO>> getAll() {
        List<UsuarioTramiteProgreso> progresos = usuarioTramiteProgresoService.list();
        List<UsuarioTramiteProgresoDTO> dtos = progresos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioTramiteProgresoDTO> getById(@PathVariable int id) {
        UsuarioTramiteProgreso progreso = usuarioTramiteProgresoService.findById(id);
        if (progreso != null) {
            return new ResponseEntity<>(toDTO(progreso), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        usuarioTramiteProgresoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/usuario/{idUsuario}/tramite/{idTramite}")
    public ResponseEntity<List<UsuarioTramiteProgresoDTO>> getByUsuarioAndTramite(@PathVariable int idUsuario, @PathVariable int idTramite) {
        List<UsuarioTramiteProgreso> progresos = usuarioTramiteProgresoService.findByUsuarioAndTramite(idUsuario, idTramite);
        List<UsuarioTramiteProgresoDTO> dtos = progresos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/usuario/{idUsuario}/tramite/{idTramite}/completados")
    public ResponseEntity<Long> countCompletedSteps(@PathVariable int idUsuario, @PathVariable int idTramite) {
        Long count = usuarioTramiteProgresoService.countCompletedStepsByUsuarioAndTramite(idUsuario, idTramite);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/usuario/{idUsuario}/tramite/{idTramite}/siguiente")
    public ResponseEntity<UsuarioTramiteProgresoDTO> findNextStep(@PathVariable int idUsuario, @PathVariable int idTramite) {
        UsuarioTramiteProgreso progreso = usuarioTramiteProgresoService.findNextStep(idUsuario, idTramite);
        if (progreso != null) {
            return new ResponseEntity<>(toDTO(progreso), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private UsuarioTramiteProgresoDTO toDTO(UsuarioTramiteProgreso entidad) {
        return new UsuarioTramiteProgresoDTO(
                entidad.getIdProgreso(),
                entidad.getIdUsuario(),
                entidad.getIdTramite(),
                entidad.getIdPaso(),
                entidad.isCompletado(),
                entidad.getFechaCompletado()
        );
    }
}
