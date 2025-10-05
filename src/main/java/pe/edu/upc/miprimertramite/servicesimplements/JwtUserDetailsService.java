package pe.edu.upc.miprimertramite.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.miprimertramite.entities.Usuario;
import pe.edu.upc.miprimertramite.repositories.IUsuarioRepositories;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepositories repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. Buscar el usuario por el nombre de usuario/email de login
        Usuario user = repo.findOneByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        }

        // --- Corrección de la lógica de Autoridades ---
        // Spring Security necesita una lista de autoridades (roles).
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        // Asumimos que la relación es Usuario (u) a TipoUsuario (t) - ManyToOne o OneToOne
        if (user.getTipoUsuario() != null) {
            // 2. Crear una autoridad usando el nombre del tipo de usuario (ej: "ADMIN", "CLIENTE")
            // Esto es crucial para que hasAuthority("ADMIN") en WebSecurityConfig funcione.
            String nombreTipo = user.getTipoUsuario().getNombreTipo();
            grantedAuthorities.add(new SimpleGrantedAuthority(nombreTipo));
        }

        // 3. Crear el objeto UserDetails
        // Usamos el constructor completo de Spring Security User
        UserDetails ud = new org.springframework.security.core.userdetails.User(
                user.getEmail(),          // Username (identificador de login)
                user.getPassword(),       // Password hasheado
                user.getEnabled(),        // Habilitado (true/false)
                true,                     // Cuenta no expirada
                true,                     // Credenciales no expiradas
                true,                     // Cuenta no bloqueada
                grantedAuthorities        // Lista de autoridades (TipoUsuario)
        );

        return ud;
    }
}
