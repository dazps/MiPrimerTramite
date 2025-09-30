package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.ComunidadRespuestaDTO;
import pe.edu.upc.miprimertramite.entities.ComunidadRespuesta;
import pe.edu.upc.miprimertramite.servicesinterfaces.IComunidadRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respuestas")
public class ComunidadRespuestaController {

    @Autowired
    private IComunidadRespuestaService comunidadRespuestaService;

    @PostMapping
    public ResponseEntity<ComunidadRespuestaDTO> create(@RequestBody ComunidadRespuestaDTO dto) {
        ComunidadRespuesta respuesta = new ComunidadRespuesta();
        respuesta.setIdPregunta(dto.getIdPregunta());
        respuesta.setIdUsuario(dto.getIdUsuario());
        respuesta.setContenido(dto.getContenido());

        ComunidadRespuesta saved = comunidadRespuestaService.save(respuesta);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ComunidadRespuestaDTO>> getAll() {
        List<ComunidadRespuesta> respuestas = comunidadRespuestaService.list();
        List<ComunidadRespuestaDTO> dtos = respuestas.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComunidadRespuestaDTO> getById(@PathVariable int id) {
        ComunidadRespuesta respuesta = comunidadRespuestaService.findById(id);
        if (respuesta != null) {
            return new ResponseEntity<>(toDTO(respuesta), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        comunidadRespuestaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pregunta/{idPregunta}")
    public ResponseEntity<List<ComunidadRespuestaDTO>> getByPreguntaId(@PathVariable int idPregunta) {
        List<ComunidadRespuesta> respuestas = comunidadRespuestaService.findByPreguntaId(idPregunta);
        List<ComunidadRespuestaDTO> dtos = respuestas.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    private ComunidadRespuestaDTO toDTO(ComunidadRespuesta entidad) {
        return new ComunidadRespuestaDTO(
                entidad.getIdRespuesta(),
                entidad.getIdPregunta(),
                entidad.getIdUsuario(),
                entidad.getContenido(),
                entidad.getFechaCreacion()
        );
    }
}
