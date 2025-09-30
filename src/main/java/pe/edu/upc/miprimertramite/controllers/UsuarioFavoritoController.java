package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.UsuarioFavoritoDTO;
import pe.edu.upc.miprimertramite.entities.UsuarioFavorito;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioFavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/favoritos")
public class UsuarioFavoritoController {

    @Autowired
    private IUsuarioFavoritoService usuarioFavoritoService;

    @PostMapping
    public ResponseEntity<UsuarioFavoritoDTO> create(@RequestBody UsuarioFavoritoDTO dto) {
        UsuarioFavorito favorito = new UsuarioFavorito();
        favorito.setIdUsuario(dto.getIdUsuario());
        favorito.setIdTramite(dto.getIdTramite());

        UsuarioFavorito saved = usuarioFavoritoService.save(favorito);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioFavoritoDTO>> getAll() {
        List<UsuarioFavorito> favoritos = usuarioFavoritoService.list();
        List<UsuarioFavoritoDTO> dtos = favoritos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioFavoritoDTO> getById(@PathVariable int id) {
        UsuarioFavorito favorito = usuarioFavoritoService.findById(id);
        if (favorito != null) {
            return new ResponseEntity<>(toDTO(favorito), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        usuarioFavoritoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<UsuarioFavoritoDTO>> getByUsuarioId(@PathVariable int idUsuario) {
        List<UsuarioFavorito> favoritos = usuarioFavoritoService.findByUsuarioId(idUsuario);
        List<UsuarioFavoritoDTO> dtos = favoritos.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/tramite/{idTramite}")
    public ResponseEntity<Long> countByTramiteId(@PathVariable int idTramite) {
        Long count = usuarioFavoritoService.countByTramiteId(idTramite);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/usuario/{idUsuario}/tramite/{idTramite}")
    public ResponseEntity<UsuarioFavoritoDTO> getByUsuarioAndTramite(@PathVariable int idUsuario, @PathVariable int idTramite) {
        UsuarioFavorito favorito = usuarioFavoritoService.findByUsuarioAndTramite(idUsuario, idTramite);
        if (favorito != null) {
            return new ResponseEntity<>(toDTO(favorito), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private UsuarioFavoritoDTO toDTO(UsuarioFavorito entidad) {
        return new UsuarioFavoritoDTO(
                entidad.getIdFavorito(),
                entidad.getIdUsuario(),
                entidad.getIdTramite(),
                entidad.getFechaAgregado()
        );
    }
}
