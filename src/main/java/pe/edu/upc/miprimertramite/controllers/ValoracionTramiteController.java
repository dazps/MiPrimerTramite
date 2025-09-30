package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.ValoracionTramiteDTO;
import pe.edu.upc.miprimertramite.entities.ValoracionTramite;
import pe.edu.upc.miprimertramite.servicesinterfaces.IValoracionTramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/valoraciones")
public class ValoracionTramiteController {

    @Autowired
    private IValoracionTramiteService valoracionTramiteService;

    @PostMapping
    public ResponseEntity<ValoracionTramiteDTO> create(@RequestBody ValoracionTramiteDTO dto) {
        ValoracionTramite valoracion = new ValoracionTramite();
        valoracion.setIdUsuario(dto.getIdUsuario());
        valoracion.setIdTramite(dto.getIdTramite());
        valoracion.setPuntuacion(dto.getPuntuacion());
        valoracion.setComentario(dto.getComentario());

        ValoracionTramite saved = valoracionTramiteService.save(valoracion);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ValoracionTramiteDTO>> getAll() {
        List<ValoracionTramite> valoraciones = valoracionTramiteService.list();
        List<ValoracionTramiteDTO> dtos = valoraciones.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValoracionTramiteDTO> getById(@PathVariable int id) {
        ValoracionTramite valoracion = valoracionTramiteService.findById(id);
        if (valoracion != null) {
            return new ResponseEntity<>(toDTO(valoracion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        valoracionTramiteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tramite/{idTramite}")
    public ResponseEntity<List<ValoracionTramiteDTO>> getByTramiteId(@PathVariable int idTramite) {
        List<ValoracionTramite> valoraciones = valoracionTramiteService.findByTramiteId(idTramite);
        List<ValoracionTramiteDTO> dtos = valoraciones.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/tramite/{idTramite}/promedio")
    public ResponseEntity<Double> getAveragePuntuacion(@PathVariable int idTramite) {
        Double promedio = valoracionTramiteService.findAveragePuntuacionByTramiteId(idTramite);
        return new ResponseEntity<>(promedio, HttpStatus.OK);
    }

    @GetMapping("/tramite/{idTramite}/cantidad")
    public ResponseEntity<Long> countByTramiteId(@PathVariable int idTramite) {
        Long count = valoracionTramiteService.countByTramiteId(idTramite);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    private ValoracionTramiteDTO toDTO(ValoracionTramite entidad) {
        return new ValoracionTramiteDTO(
                entidad.getIdValoracion(),
                entidad.getIdUsuario(),
                entidad.getIdTramite(),
                entidad.getPuntuacion(),
                entidad.getComentario(),
                entidad.getFecha()
        );
    }
}
