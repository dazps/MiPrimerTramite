package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.TipoNotificacionDTO;
import pe.edu.upc.miprimertramite.entities.TipoNotificacion;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITipoNotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipos-notificacion")
public class TipoNotificacionController {

    @Autowired
    private ITipoNotificacionService tipoNotificacionService;

    @PostMapping
    public ResponseEntity<TipoNotificacionDTO> create(@RequestBody TipoNotificacionDTO dto) {
        TipoNotificacion tipo = new TipoNotificacion();
        tipo.setNombre(dto.getNombre());
        tipo.setDescripcion(dto.getDescripcion());

        TipoNotificacion saved = tipoNotificacionService.save(tipo);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TipoNotificacionDTO>> getAll() {
        List<TipoNotificacion> tipos = tipoNotificacionService.list();
        List<TipoNotificacionDTO> dtos = tipos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoNotificacionDTO> getById(@PathVariable int id) {
        TipoNotificacion tipo = tipoNotificacionService.findById(id);
        if (tipo != null) {
            return new ResponseEntity<>(toDTO(tipo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        tipoNotificacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<TipoNotificacionDTO> getByNombre(@PathVariable String nombre) {
        TipoNotificacion tipo = tipoNotificacionService.findByNombre(nombre);
        if (tipo != null) {
            return new ResponseEntity<>(toDTO(tipo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private TipoNotificacionDTO toDTO(TipoNotificacion entidad) {
        return new TipoNotificacionDTO(
                entidad.getIdTipoNotificacion(),
                entidad.getNombre(),
                entidad.getDescripcion()
        );
    }
}
