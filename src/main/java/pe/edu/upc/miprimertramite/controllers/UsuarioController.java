package pe.edu.upc.miprimertramite.controllers;

import pe.edu.upc.miprimertramite.dtos.UsuarioDTO;
import pe.edu.upc.miprimertramite.entities.Usuario;
import pe.edu.upc.miprimertramite.servicesinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setIdTipoUsuario(dto.getIdTipoUsuario());
        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setTelefono(dto.getTelefono());

        Usuario saved = usuarioService.save(usuario);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<Usuario> usuarios = usuarioService.list();
        List<UsuarioDTO> dtos = usuarios.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable int id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            return new ResponseEntity<>(toDTO(usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> getByEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.findByEmail(email);
        if (usuario != null) {
            return new ResponseEntity<>(toDTO(usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tipo/{nombreTipo}")
    public ResponseEntity<List<UsuarioDTO>> getByTipoUsuarioNombre(@PathVariable String nombreTipo) {
        List<Usuario> usuarios = usuarioService.findByTipoUsuarioNombre(nombreTipo);
        List<UsuarioDTO> dtos = usuarios.stream().map(this::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    private UsuarioDTO toDTO(Usuario entidad) {
        return new UsuarioDTO(
                entidad.getIdUsuario(),
                entidad.getIdTipoUsuario(),
                entidad.getNombreCompleto(),
                entidad.getEmail(),
                entidad.getTelefono(),
                entidad.getUltimoLogin()
        );
    }
}
