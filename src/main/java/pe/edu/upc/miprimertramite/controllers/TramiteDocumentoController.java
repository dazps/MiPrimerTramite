package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.TramiteDocumentoDTO;
import pe.edu.upc.miprimertramite.entities.TramiteDocumento;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramiteDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tramites-documentos")
public class TramiteDocumentoController {

    @Autowired
    private ITramiteDocumentoService tramiteDocumentoService;

    @PostMapping
    public ResponseEntity<TramiteDocumentoDTO> create(@RequestBody TramiteDocumentoDTO dto) {
        TramiteDocumento documento = new TramiteDocumento();
        documento.setIdTramite(dto.getIdTramite());
        documento.setNombre(dto.getNombre());
        documento.setEsOpcional(dto.isEsOpcional());

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
        tramiteDocumentoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tramite/{idTramite}")
    public ResponseEntity<List<TramiteDocumentoDTO>> getByTramiteId(@PathVariable int idTramite) {
        List<TramiteDocumento> documentos = tramiteDocumentoService.findByTramiteId(idTramite);
        List<TramiteDocumentoDTO> dtos = documentos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    private TramiteDocumentoDTO toDTO(TramiteDocumento entidad) {
        return new TramiteDocumentoDTO(
                entidad.getIdDocumento(),
                entidad.getIdTramite(),
                entidad.getNombre(),
                entidad.isEsOpcional()
        );
    }
}
