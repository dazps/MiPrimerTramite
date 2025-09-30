package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.TramiteDTO;
import pe.edu.upc.miprimertramite.entities.Tramite;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tramites")
public class TramiteController {

    @Autowired
    private ITramiteService tramiteService;

    @PostMapping
    public ResponseEntity<TramiteDTO> create(@RequestBody TramiteDTO dto) {
        Tramite tramite = new Tramite();
        tramite.setTitulo(dto.getTitulo());
        tramite.setDescripcion(dto.getDescripcion());
        tramite.setPopularidad(dto.getPopularidad());

        Tramite saved = tramiteService.save(tramite);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TramiteDTO>> getAll() {
        List<Tramite> tramites = tramiteService.list();
        List<TramiteDTO> dtos = tramites.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TramiteDTO> getById(@PathVariable int id) {
        Tramite tramite = tramiteService.findById(id);
        if (tramite != null) {
            return new ResponseEntity<>(toDTO(tramite), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        tramiteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/top10")
    public ResponseEntity<List<TramiteDTO>> getTop10ByPopularidad() {
        List<Tramite> tramites = tramiteService.findTop10ByPopularidad();
        List<TramiteDTO> dtos = tramites.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/min-puntuacion/{minPuntuacion}")
    public ResponseEntity<List<TramiteDTO>> getByMinPuntuacion(@PathVariable int minPuntuacion) {
        List<Tramite> tramites = tramiteService.findByMinPuntuacion(minPuntuacion);
        List<TramiteDTO> dtos = tramites.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    private TramiteDTO toDTO(Tramite entidad) {
        return new TramiteDTO(
                entidad.getIdTramite(),
                entidad.getTitulo(),
                entidad.getDescripcion(),
                entidad.getPopularidad(),
                entidad.getActualizadoEn()
        );
    }
}
