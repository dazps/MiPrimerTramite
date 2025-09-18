import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInit {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/miprimertramite";
        String user = "postgres";
        String password = "postgre";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sql = """
            
            CREATE TABLE Tipo_Usuarios (
                ID_TipoUsuario SERIAL PRIMARY KEY,
                Nombre VARCHAR(50),
                Descripcion VARCHAR(150)
            );
            
            CREATE TABLE Usuarios (
                ID_Usuario BIGSERIAL PRIMARY KEY,
                ID_TipoUsuario INT REFERENCES Tipo_Usuarios(ID_TipoUsuario),
                NombreCompleto VARCHAR(150),
                Email VARCHAR(150),
                Password VARCHAR(150),
                Telefono VARCHAR(30),
                UltimoLogin TIMESTAMPTZ
            );
            
            CREATE TABLE Tramites (
                ID_Tramite BIGSERIAL PRIMARY KEY,
                Titulo VARCHAR(200),
                Descripcion TEXT,
                Popularidad INT,
                ActualizadoEn TIMESTAMPTZ
            );
            
            CREATE TABLE Tramite_Pasos (
                ID_Paso BIGSERIAL PRIMARY KEY,
                ID_Tramite BIGINT REFERENCES Tramites(ID_Tramite),
                Orden INT,
                Titulo VARCHAR(150),
                Descri TEXT
            );
            
            CREATE TABLE Tramite_Documentos (
                ID_Documento BIGSERIAL PRIMARY KEY,
                ID_Tramite BIGINT REFERENCES Tramites(ID_Tramite),
                Nombre VARCHAR(150),
                EsOpcional BOOLEAN
            );
            
            CREATE TABLE Usuario_Tramite_Progreso (
                ID_Progreso BIGSERIAL PRIMARY KEY,
                ID_Usuario BIGINT REFERENCES Usuarios(ID_Usuario),
                ID_Tramite BIGINT REFERENCES Tramites(ID_Tramite),
                ID_Paso BIGINT REFERENCES Tramite_Pasos(ID_Paso),
                Completado BOOLEAN,
                FechaCompletado TIMESTAMPTZ
            );
            
            CREATE TABLE Valoraciones_Tramites (
                ID_Valoracion BIGSERIAL PRIMARY KEY,
                ID_Usuario BIGINT REFERENCES Usuarios(ID_Usuario),
                ID_Tramite BIGINT REFERENCES Tramites(ID_Tramite),
                Puntuacion INT,
                Comentario TEXT,
                Fecha TIMESTAMPTZ
            );
            
            CREATE TABLE Usuario_Favoritos (
                ID_Favorito BIGSERIAL PRIMARY KEY,
                ID_Usuario BIGINT REFERENCES Usuarios(ID_Usuario),
                ID_Tramite BIGINT REFERENCES Tramites(ID_Tramite),
                FechaAgregada TIMESTAMPTZ
            );
            
            CREATE TABLE Comunidad_Preguntas (
                ID_Pregunta BIGSERIAL PRIMARY KEY,
                ID_Usuario BIGINT REFERENCES Usuarios(ID_Usuario),
                Titulo VARCHAR(200),
                Contenido TEXT,
                FechaCreacion TIMESTAMPTZ
            );
            
            CREATE TABLE Comunidad_Respuestas (
                ID_Respuesta BIGSERIAL PRIMARY KEY,
                ID_Pregunta BIGINT REFERENCES Comunidad_Preguntas(ID_Pregunta),
                ID_Usuario BIGINT REFERENCES Usuarios(ID_Usuario),
                Contenido TEXT,
                FechaCreacion TIMESTAMPTZ
            );
            
            CREATE TABLE Actividad_Sistema (
                ID_Actividad BIGSERIAL PRIMARY KEY,
                ID_Usuario BIGINT REFERENCES Usuarios(ID_Usuario),
                TipoActividad VARCHAR(50),
                Descripcion TEXT,
                Fecha TIMESTAMPTZ
            );
            
            CREATE TABLE Tipo_Notificaciones (
                ID_TipoNotificacion SERIAL PRIMARY KEY,
                Nombre VARCHAR(50),
                Descripcion VARCHAR(150)
            );
            
            CREATE TABLE Notificaciones (
                ID_Notificacion BIGSERIAL PRIMARY KEY,
                ID_Usuario BIGINT REFERENCES Usuarios(ID_Usuario),
                ID_TipoNotificacion INT REFERENCES Tipo_Notificaciones(ID_TipoNotificacion),
                Titulo VARCHAR(200),
                Mensaje TEXT,
                FechaProgramada TIMESTAMPTZ,
                Enviado BOOLEAN
            );
            """;

            stmt.execute(sql);
            System.out.println("Base de datos creada correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}