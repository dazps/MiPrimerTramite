package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.TramitePasoDTO;
import pe.edu.upc.miprimertramite.entities.TramitePaso;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramitePasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tramites-pasos")
public class TramitePasoController {

    @Autowired
    private ITramitePasoService tramitePasoService;

    @PostMapping
    public ResponseEntity<TramitePasoDTO> create(@RequestBody TramitePasoDTO dto) {
        TramitePaso paso = new TramitePaso();
        paso.setIdTram(dto.getIdTram());
        paso.setOrden(dto.getOrden());
        paso.setTitulo(dto.getTitulo());
        paso.setDescripc(dto.getDescripc());

        TramitePaso saved = tramitePasoService.save(paso);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TramitePasoDTO>> getAll() {
        List<TramitePaso> pasos = tramitePasoService.list();
        List<TramitePasoDTO> dtos = pasos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TramitePasoDTO> getById(@PathVariable int id) {
        TramitePaso paso = tramitePasoService.findById(id);
        if (paso != null) {
            return new ResponseEntity<>(toDTO(paso), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        tramitePasoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tramite/{idTramite}")
    public ResponseEntity<List<TramitePasoDTO>> getByTramiteId(@PathVariable int idTramite) {
        List<TramitePaso> pasos = tramitePasoService.findByTramiteId(idTramite);
        List<TramitePasoDTO> dtos = pasos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/tramite/{idTramite}/ordenados")
    public ResponseEntity<List<TramitePasoDTO>> getByTramiteIdOrdered(@PathVariable int idTramite) {
        List<TramitePaso> pasos = tramitePasoService.findByTramiteIdOrdered(idTramite);
        List<TramitePasoDTO> dtos = pasos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    private TramitePasoDTO toDTO(TramitePaso entidad) {
        return new TramitePasoDTO(
                entidad.getIdPaso(),
                entidad.getIdTram(),
                entidad.getOrden(),
                entidad.getTitulo(),
                entidad.getDescripc()
        );
    }
}
