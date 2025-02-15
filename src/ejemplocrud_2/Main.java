// Declaración del paquete donde se encuentra esta clase
package ejemplocrud_2;

// Importa las clases necesarias
import java.util.List; // Permite el uso de listas
import java.util.Scanner; // Permite la entrada de datos por consola

// Definición de la clase principal
public class Main {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Crea una instancia de ArtistaDAO, que maneja las operaciones CRUD
        ArtistaDAO artistaDAO = new ArtistaDAO();

        // Bucle infinito para mostrar el menú hasta que el usuario decida salir
        while (true) {
            // Muestra el menú de opciones en la consola
            System.out.println("\n=== CRUD de Artistas ===");
            System.out.println("1. Agregar Artista");
            System.out.println("2. Listar Artistas");
            System.out.println("3. Actualizar Artista");
            System.out.println("4. Eliminar Artista");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Lee la opción ingresada por el usuario
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner después de leer un número
            
            // Estructura switch para manejar la opción seleccionada
            switch (opcion) {
                case 1:
                    // Opción para agregar un artista
                    System.out.print("Ingrese el nombre del artista: ");
                    String nombre = scanner.nextLine(); // Lee el nombre del artista
                    System.out.print("Ingrese el género musical: ");
                    String genero = scanner.nextLine(); // Lee el género musical
                    // Crea un nuevo objeto Artista con los datos ingresados
                    Artista nuevoArtista = new Artista(0, nombre, genero);
                    // Llama al método para agregar el artista en la base de datos
                    artistaDAO.crearArtista(nuevoArtista);
                    break;
                
                case 2:
                    // Opción para listar los artistas
                    List<Artista> artistas = artistaDAO.obtenerArtistas(); // Obtiene la lista de artistas
                    System.out.println("\n=== Lista de Artistas ===");
                    // Itera sobre la lista e imprime cada artista
                    for (Artista a : artistas) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    // Opción para actualizar los datos de un artista
                    System.out.print("Ingrese el ID del artista a actualizar: ");
                    int idActualizar = scanner.nextInt(); // Lee el ID del artista a actualizar
                    scanner.nextLine(); // Limpia el buffer del scanner
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine(); // Lee el nuevo nombre
                    System.out.print("Ingrese el nuevo género musical: ");
                    String nuevoGenero = scanner.nextLine(); // Lee el nuevo género musical
                    // Llama al método para actualizar el artista en la base de datos
                    artistaDAO.actualizarArtista(idActualizar, nuevoNombre, nuevoGenero);
                    break;

                case 4:
                    // Opción para eliminar un artista
                    System.out.print("Ingrese el ID del artista a eliminar: ");
                    int idEliminar = scanner.nextInt(); // Lee el ID del artista a eliminar
                    // Llama al método para eliminar el artista en la base de datos
                    artistaDAO.eliminarArtista(idEliminar);
                    break;

                case 5:
                    // Opción para salir del programa
                    System.out.println("Saliendo del sistema...");
                    scanner.close(); // Cierra el scanner antes de salir
                    return; // Sale del método main y finaliza el programa

                default:
                    // Mensaje en caso de que el usuario ingrese una opción no válida
                    System.out.println("⚠️ Opción no válida, intente nuevamente.");
            }
        }
    }
}
