// Definimos el paquete donde se encuentra la clase
package ejemplocrud_2;

// Importamos las clases necesarias para la conexión y manipulación de la base de datos
import java.sql.*; // Contiene Connection, PreparedStatement, ResultSet, Statement, SQLException
import java.util.ArrayList;
import java.util.List;

// Clase encargada de realizar las operaciones CRUD (Create, Read, Update, Delete) en la tabla "artista"
public class ArtistaDAO {
    
    // Método para insertar un artista en la base de datos
    public void crearArtista(Artista artista) {
        // Definimos la consulta SQL para insertar un nuevo artista, con parámetros (?) para prevenir inyección SQL
        String sql = "INSERT INTO artista (Nombre, Genero_Musical) VALUES (?, ?)";
        
        // Uso de try-with-resources para garantizar el cierre de la conexión y los recursos
        try (Connection conn = ConexionBD.getConnection(); // Obtener conexión a la base de datos
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL con parámetros
            
            // Asignamos valores a los parámetros de la consulta
            pstmt.setString(1, artista.getNombre()); // Primer parámetro: Nombre del artista
            pstmt.setString(2, artista.getGeneroMusical()); // Segundo parámetro: Género musical
            
            // Ejecutamos la consulta para insertar el registro
            pstmt.executeUpdate();
            System.out.println("✅ Artista agregado exitosamente.");
            
        } catch (SQLException e) {
            // Captura cualquier error de SQL y lo muestra en la consola
            e.printStackTrace();
        }
    }

    // Método para obtener todos los artistas de la base de datos
    public List<Artista> obtenerArtistas() {
        List<Artista> lista = new ArrayList<>(); // Lista donde se almacenarán los artistas obtenidos
        
        // Definimos la consulta SQL para seleccionar todos los registros de la tabla "artista"
        String sql = "SELECT * FROM artista";

        // Uso de try-with-resources para gestionar los recursos de conexión
        try (Connection conn = ConexionBD.getConnection(); // Obtener conexión
             Statement stmt = conn.createStatement(); // Crear un objeto Statement para ejecutar la consulta
             ResultSet rs = stmt.executeQuery(sql)) { // Ejecutar la consulta y almacenar los resultados en ResultSet

            // Recorremos los resultados fila por fila
            while (rs.next()) {
                // Creamos un objeto Artista con los datos obtenidos de la base de datos
                Artista artista = new Artista(
                        rs.getInt("ID_Artista"), // Obtener el ID del artista
                        rs.getString("Nombre"), // Obtener el nombre del artista
                        rs.getString("Genero_Musical") // Obtener el género musical
                );
                lista.add(artista); // Agregamos el artista a la lista
            }
        } catch (SQLException e) {
            // Captura cualquier error de SQL y lo muestra en la consola
            e.printStackTrace();
        }
        
        return lista; // Retornamos la lista con todos los artistas obtenidos
    }

    // Método para actualizar un artista en la base de datos por su ID
    public void actualizarArtista(int id, String nuevoNombre, String nuevoGenero) {
        // Definimos la consulta SQL para actualizar un artista, utilizando parámetros (?) para mayor seguridad
        String sql = "UPDATE artista SET Nombre = ?, Genero_Musical = ? WHERE ID_Artista = ?";
        
        // Uso de try-with-resources para gestionar la conexión y recursos
        try (Connection conn = ConexionBD.getConnection(); // Obtener conexión
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL
            
            // Asignamos los valores a los parámetros de la consulta
            pstmt.setString(1, nuevoNombre); // Primer parámetro: Nuevo nombre del artista
            pstmt.setString(2, nuevoGenero); // Segundo parámetro: Nuevo género musical
            pstmt.setInt(3, id); // Tercer parámetro: ID del artista que queremos actualizar
            
            // Ejecutamos la consulta y obtenemos el número de filas afectadas
            int filasActualizadas = pstmt.executeUpdate();

            // Verificamos si se realizó la actualización correctamente
            if (filasActualizadas > 0) {
                System.out.println("✅ Artista actualizado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el artista con ID: " + id);
            }
        } catch (SQLException e) {
            // Captura cualquier error de SQL y lo muestra en la consola
            e.printStackTrace();
        }
    }

    // Método para eliminar un artista de la base de datos por su ID
    public void eliminarArtista(int id) {
        // Definimos la consulta SQL para eliminar un artista con el ID especificado
        String sql = "DELETE FROM artista WHERE ID_Artista = ?";
        
        // Uso de try-with-resources para gestionar la conexión y los recursos
        try (Connection conn = ConexionBD.getConnection(); // Obtener conexión
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL
            
            // Asignamos el valor del ID al parámetro de la consulta
            pstmt.setInt(1, id);

            // Ejecutamos la consulta y obtenemos el número de filas eliminadas
            int filasEliminadas = pstmt.executeUpdate();

            // Verificamos si se realizó la eliminación correctamente
            if (filasEliminadas > 0) {
                System.out.println("✅ Artista eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el artista con ID: " + id);
            }
        } catch (SQLException e) {
            // Captura cualquier error de SQL y lo muestra en la consola
            e.printStackTrace();
        }
    }
}
