package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.ComunidadPreguntaDTO;
import pe.edu.upc.miprimertramite.entities.ComunidadPregunta;
import pe.edu.upc.miprimertramite.servicesinterfaces.IComunidadPreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/preguntas")
public class ComunidadPreguntaController {

    @Autowired
    private IComunidadPreguntaService comunidadPreguntaService;

    @PostMapping
    public ResponseEntity<ComunidadPreguntaDTO> create(@RequestBody ComunidadPreguntaDTO dto) {
        ComunidadPregunta pregunta = new ComunidadPregunta();
        pregunta.setIdUsuario(dto.getIdUsuario());
        pregunta.setTitulo(dto.getTitulo());
        pregunta.setContenido(dto.getContenido());

        ComunidadPregunta saved = comunidadPreguntaService.save(pregunta);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ComunidadPreguntaDTO>> getAll() {
        List<ComunidadPregunta> preguntas = comunidadPreguntaService.list();
        List<ComunidadPreguntaDTO> dtos = preguntas.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComunidadPreguntaDTO> getById(@PathVariable int id) {
        ComunidadPregunta pregunta = comunidadPreguntaService.findById(id);
        if (pregunta != null) {
            return new ResponseEntity<>(toDTO(pregunta), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        comunidadPreguntaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ComunidadPreguntaDTO>> getByUsuarioId(@PathVariable int idUsuario) {
        List<ComunidadPregunta> preguntas = comunidadPreguntaService.findByUsuarioId(idUsuario);
        List<ComunidadPreguntaDTO> dtos = preguntas.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/latest5")
    public ResponseEntity<List<ComunidadPreguntaDTO>> getLatest5() {
        List<ComunidadPregunta> preguntas = comunidadPreguntaService.findLatest5();
        List<ComunidadPreguntaDTO> dtos = preguntas.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    private ComunidadPreguntaDTO toDTO(ComunidadPregunta entidad) {
        return new ComunidadPreguntaDTO(
                entidad.getIdPregunta(),
                entidad.getIdUsuario(),
                entidad.getTitulo(),
                entidad.getContenido(),
                entidad.getFechaCreacion()
        );
    }
}
