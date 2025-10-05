package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.ActividadSistemaDTO;
import pe.edu.upc.miprimertramite.entities.ActividadSistema;
import pe.edu.upc.miprimertramite.entities.Usuario;
import pe.edu.upc.miprimertramite.servicesinterfaces.IActividadSistemaService;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividades")
public class ActividadSistemaController {

    @Autowired
    private IActividadSistemaService actividadSistemaService;

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ActividadSistemaDTO> create(@RequestBody ActividadSistemaDTO dto) {
        // Obtener entidad relacionada
        Usuario usuario = usuarioService.findById(dto.getIdUsuario());
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ActividadSistema actividad = new ActividadSistema();
        actividad.setUsuario(usuario);
        actividad.setTipoActividad(dto.getTipoActividad());
        actividad.setDescripcion(dto.getDescripcion());
        actividad.setFecha(LocalDateTime.now());

        ActividadSistema saved = actividadSistemaService.save(actividad);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadSistemaDTO> update(@PathVariable int id, @RequestBody ActividadSistemaDTO dto) {
        ActividadSistema actividad = actividadSistemaService.findById(id);
        if (actividad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Actualizar campos
        actividad.setTipoActividad(dto.getTipoActividad());
        actividad.setDescripcion(dto.getDescripcion());

        // Si se actualiza el usuario
        if (dto.getIdUsuario() != actividad.getUsuario().getIdUsuario()) {
            Usuario usuario = usuarioService.findById(dto.getIdUsuario());
            if (usuario == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            actividad.setUsuario(usuario);
        }

        ActividadSistema updated = actividadSistemaService.save(actividad);
        return new ResponseEntity<>(toDTO(updated), HttpStatus.OK);
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
        ActividadSistema actividad = actividadSistemaService.findById(id);
        if (actividad != null) {
            actividadSistemaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ActividadSistemaDTO>> getLatest10ByUsuarioId(@PathVariable int idUsuario) {
        List<ActividadSistema> actividades = actividadSistemaService.findLatest10ByUsuarioId(idUsuario);
        List<ActividadSistemaDTO> dtos = actividades.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    private ActividadSistemaDTO toDTO(ActividadSistema entidad) {
        return new ActividadSistemaDTO(
                entidad.getIdActividad(),
                entidad.getUsuario().getIdUsuario(),
                entidad.getTipoActividad(),
                entidad.getDescripcion(),
                entidad.getFecha()
        );
    }
}