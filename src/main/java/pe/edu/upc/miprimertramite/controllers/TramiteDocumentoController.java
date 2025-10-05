package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.TramiteDocumentoDTO;
import pe.edu.upc.miprimertramite.entities.TramiteDocumento;
import pe.edu.upc.miprimertramite.entities.Tramite;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramiteDocumentoService;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tramitesdocumentos")
public class TramiteDocumentoController {

    @Autowired
    private ITramiteDocumentoService tramiteDocumentoService;

    @Autowired
    private ITramiteService tramiteService;

    @PostMapping
    public ResponseEntity<TramiteDocumentoDTO> create(@RequestBody TramiteDocumentoDTO dto) {
        // Obtener entidad relacionada
        Tramite tramite = tramiteService.findById(dto.getIdTramite());
        if (tramite == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        TramiteDocumento documento = new TramiteDocumento();
        documento.setTramite(tramite);
        documento.setNombre(dto.getNombre());
        documento.setEsOpcional(dto.getEsOpcional());

        TramiteDocumento saved = tramiteDocumentoService.save(documento);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TramiteDocumentoDTO>> getAll() {
        List<TramiteDocumento> documentos = tramiteDocumentoService.list();
        List<TramiteDocumentoDTO> dtos = documentos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TramiteDocumentoDTO> getById(@PathVariable int id) {
        TramiteDocumento documento = tramiteDocumentoService.findById(id);
        if (documento != null) {
            return new ResponseEntity<>(toDTO(documento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        TramiteDocumento documento = tramiteDocumentoService.findById(id);
        if (documento != null) {
            tramiteDocumentoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tramite/{idTramite}")
    public ResponseEntity<List<TramiteDocumentoDTO>> getByTramiteId(@PathVariable int idTramite) {
        List<TramiteDocumento> documentos = tramiteDocumentoService.findByTramiteId(idTramite);
        List<TramiteDocumentoDTO> dtos = documentos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/tramite/{idTramite}/count")
    public ResponseEntity<Long> countByTramiteId(@PathVariable int idTramite) {
        Long count = tramiteDocumentoService.countRequiredDocumentsByTramiteId(idTramite);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    private TramiteDocumentoDTO toDTO(TramiteDocumento entidad) {
        return new TramiteDocumentoDTO(
                entidad.getIdDocumento(),
                entidad.getNombre(),
                entidad.getEsOpcional(),
                entidad.getTramite().getIdTramite()
        );
    }
}