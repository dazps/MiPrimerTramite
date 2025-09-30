package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.ActividadSistemaDTO;
import pe.edu.upc.miprimertramite.entities.ActividadSistema;
import pe.edu.upc.miprimertramite.servicesinterfaces.IActividadSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividades")
public class ActividadSistemaController {

    @Autowired
    private IActividadSistemaService actividadSistemaService;

    @PostMapping
    public ResponseEntity<ActividadSistemaDTO> create(@RequestBody ActividadSistemaDTO dto) {
        ActividadSistema actividad = new ActividadSistema();
        actividad.setIdUsuario(dto.getIdUsuario());
        actividad.setTipoActividad(dto.getTipoActividad());
        actividad.setDescripcion(dto.getDescripcion());

        ActividadSistema saved = actividadSistemaService.save(actividad);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ActividadSistemaDTO>> getAll() {
        List<ActividadSistema> actividades = actividadSistemaService.list();
        List<ActividadSistemaDTO> dtos = actividades.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadSistemaDTO> getById(@PathVariable int id) {
        ActividadSistema actividad = actividadSistemaService.findById(id);
        if (actividad != null) {
            return new ResponseEntity<>(toDTO(actividad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        actividadSistemaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ActividadSistemaDTO>> getLatest10ByUsuarioId(@PathVariable int idUsuario) {
        List<ActividadSistema> actividades = actividadSistemaService.findLatest10ByUsuarioId(idUsuario);
        List<ActividadSistemaDTO> dtos = actividades.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    // Helper: Convertir Entidad a DTO
    private ActividadSistemaDTO toDTO(ActividadSistema entidad) {
        return new ActividadSistemaDTO(
                entidad.getIdActividad(),
                entidad.getIdUsuario(),
                entidad.getTipoActividad(),
                entidad.getDescripcion(),
                entidad.getFecha()
        );
    }
}
