package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.UsuarioFavoritoDTO;
import pe.edu.upc.miprimertramite.entities.UsuarioFavorito;
import pe.edu.upc.miprimertramite.entities.Usuario;
import pe.edu.upc.miprimertramite.entities.Tramite;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioFavoritoService;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioService;
import pe.edu.upc.miprimertramite.servicesinterfaces.ITramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/favoritos")
public class UsuarioFavoritoController {

    @Autowired
    private IUsuarioFavoritoService usuarioFavoritoService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ITramiteService tramiteService;

    @PostMapping
    public ResponseEntity<UsuarioFavoritoDTO> create(@RequestBody UsuarioFavoritoDTO dto) {
        // Verificar si ya existe un favorito para este usuario y trámite
        UsuarioFavorito existing = usuarioFavoritoService.findByUsuarioAndTramite(dto.getIdUsuario(), dto.getIdTramite());
        if (existing != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        // Obtener entidades relacionadas
        Usuario usuario = usuarioService.findById(dto.getIdUsuario());
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Tramite tramite = tramiteService.findById(dto.getIdTramite());
        if (tramite == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UsuarioFavorito favorito = new UsuarioFavorito();
        favorito.setUsuario(usuario);
        favorito.setTramite(tramite);
        favorito.setFechaAgregado(LocalDateTime.now());

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
        UsuarioFavorito favorito = usuarioFavoritoService.findById(id);
        if (favorito != null) {
            usuarioFavoritoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/usuario/{idUsuario}/tramite/{idTramite}")
    public ResponseEntity<Void> deleteByUsuarioAndTramite(@PathVariable int idUsuario, @PathVariable int idTramite) {
        UsuarioFavorito favorito = usuarioFavoritoService.findByUsuarioAndTramite(idUsuario, idTramite);
        if (favorito != null) {
            usuarioFavoritoService.delete(favorito.getIdFavorito());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
                entidad.getUsuario().getIdUsuario(),
                entidad.getTramite().getIdTramite(),
                entidad.getFechaAgregado()
        );
    }
}