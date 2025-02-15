// Definición del paquete donde se encuentra la clase
package ejemplocrud_2;

// Clase que representa un artista en el sistema
public class Artista {
    
    // Atributo que almacena el ID del artista (clave primaria en la base de datos)
    private int id;
    
    // Atributo que almacena el nombre del artista
    private String nombre;
    
    // Atributo que almacena el género musical del artista
    private String generoMusical;

    // Constructor vacío (permite crear un objeto Artista sin inicializar atributos)
    public Artista() {}

    // Constructor con parámetros (permite crear un objeto Artista con datos específicos)
    public Artista(int id, String nombre, String generoMusical) {
        this.id = id; // Asigna el valor del ID
        this.nombre = nombre; // Asigna el nombre del artista
        this.generoMusical = generoMusical; // Asigna el género musical del artista
    }

    // Métodos Getters y Setters (encapsulación de los atributos)

    // Devuelve el ID del artista
    public int getId() { return id; }
    
    // Asigna un nuevo valor al ID del artista
    public void setId(int id) { this.id = id; }

    // Devuelve el nombre del artista
    public String getNombre() { return nombre; }
    
    // Asigna un nuevo nombre al artista
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Devuelve el género musical del artista
    public String getGeneroMusical() { return generoMusical; }
    
    // Asigna un nuevo género musical al artista
    public void setGeneroMusical(String generoMusical) { this.generoMusical = generoMusical; }

    // Método toString sobrescrito para mostrar la información del artista de forma legible
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Género Musical: " + generoMusical;
    }
}
