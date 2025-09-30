package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.NotificacionDTO;
import pe.edu.upc.miprimertramite.entities.Notificacion;
import pe.edu.upc.miprimertramite.servicesinterfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService notificacionService;

    @PostMapping
    public ResponseEntity<NotificacionDTO> create(@RequestBody NotificacionDTO dto) {
        Notificacion notificacion = new Notificacion();
        notificacion.setIdUsuario(dto.getIdUsuario());
        notificacion.setIdTipoNotificacion(dto.getIdTipoNotificacion());
        notificacion.setTitulo(dto.getTitulo());
        notificacion.setMensaje(dto.getMensaje());
        notificacion.setFechaProgramada(dto.getFechaProgramada());
        notificacion.setEnviado(dto.isEnviado());

        Notificacion saved = notificacionService.save(notificacion);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NotificacionDTO>> getAll() {
        List<Notificacion> notificaciones = notificacionService.list();
        List<NotificacionDTO> dtos = notificaciones.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> getById(@PathVariable int id) {
        Notificacion notificacion = notificacionService.findById(id);
        if (notificacion != null) {
            return new ResponseEntity<>(toDTO(notificacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        notificacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/usuario/{idUsuario}/pendientes")
    public ResponseEntity<List<NotificacionDTO>> getPendingByUsuarioId(@PathVariable int idUsuario) {
        List<Notificacion> notificaciones = notificacionService.findPendingByUsuarioId(idUsuario);
        List<NotificacionDTO> dtos = notificaciones.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PutMapping("/{id}/marcar-enviada")
    public ResponseEntity<NotificacionDTO> markAsSent(@PathVariable int id) {
        Notificacion notificacion = notificacionService.markAsSent(id);
        if (notificacion != null) {
            return new ResponseEntity<>(toDTO(notificacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private NotificacionDTO toDTO(Notificacion entidad) {
        return new NotificacionDTO(
                entidad.getIdNotificacion(),
                entidad.getIdUsuario(),
                entidad.getIdTipoNotificacion(),
                entidad.getTitulo(),
                entidad.getMensaje(),
                entidad.getFechaProgramada(),
                entidad.isEnviado()
        );
    }
}
