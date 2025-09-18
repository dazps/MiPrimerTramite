package com.example.miprimertramitegithub2025;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // INSERTAR
        Usuario nuevo = new Usuario("Eder Mauricio", "eder@mail.com", "12345", "987654321");
        dao.insertarUsuario(nuevo);

        // LISTAR
        System.out.println("📋 Lista de usuarios:");
        for (Usuario u : dao.listarUsuarios()) {
            System.out.println(u.getIdUsuario() + " - " + u.getNombreCompleto());
        }

        // ACTUALIZAR
        Usuario editar = new Usuario("Eder M. Editado", "nuevo@mail.com", "abc123", "999999999");
        editar.setIdUsuario(1); // 👈 ID existente en la BD
        dao.actualizarUsuario(editar);

        // ELIMINAR
        dao.eliminarUsuario(1);
    }
}
