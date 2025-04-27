import services.CsvService; // Importa el servicio para manejar operaciones con archivos CSV
import models.Cultivo; // Importa la clase Cultivo que representa un cultivo
import ui.Menu; // Importa la clase Menu que gestiona la interfaz de usuario
import java.io.IOException; // Importa la clase IOException para manejar excepciones de entrada/salida
import java.util.List; // Importa la clase List para manejar listas de cultivos

// Clase principal de la aplicación
public class App2 {
    public static void main(String[] args) {
        // Verifica si se ha proporcionado un argumento (nombre del archivo CSV)
        if (args.length < 1) {
            System.out.println("Uso: java App2 cultivos.csv"); // Informa al usuario sobre el uso correcto
            return; // Sale del método si no se proporciona el archivo
        }
        String archivo = args[0]; // Asigna el nombre del archivo CSV desde los argumentos

        try {
            // Lee los cultivos desde el archivo CSV y los almacena en una lista
            List<Cultivo> cultivos = CsvService.leerCultivosDesdeCSV(archivo);
            // Muestra el menú principal para gestionar los cultivos
            Menu.mostrarMenu(cultivos);
            // Guarda los cambios realizados en la lista de cultivos de vuelta en el archivo CSV
            CsvService.guardarCultivosEnCSV(cultivos, archivo);
            System.out.println("Cambios guardados en " + archivo); // Confirma que los cambios han sido guardados
        } catch (IOException e) {
            // Maneja cualquier excepción de entrada/salida que ocurra durante la lectura o escritura del archivo
            System.err.println("Error CSV: " + e.getMessage()); // Muestra un mensaje de error
        }
    }
}
