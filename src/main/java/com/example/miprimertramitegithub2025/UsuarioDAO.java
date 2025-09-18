package com.example.miprimertramitegithub2025;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // CREATE
    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombrecomple, email, password, telefono) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombreCompleto());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getPassword());
            stmt.setString(4, usuario.getTelefono());
            stmt.executeUpdate();

            System.out.println(" Usuario insertado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getLong("id_usuario"));
                u.setNombreCompleto(rs.getString("nombrecomple"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setTelefono(rs.getString("telefono"));
                lista.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // UPDATE
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombrecomple=?, email=?, password=?, telefono=? WHERE id_usuario=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombreCompleto());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getPassword());
            stmt.setString(4, usuario.getTelefono());
            stmt.setLong(5, usuario.getIdUsuario());
            stmt.executeUpdate();

            System.out.println(" Usuario actualizado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void eliminarUsuario(long idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idUsuario);
            stmt.executeUpdate();

            System.out.println(" Usuario eliminado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
