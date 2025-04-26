import services.CsvService;
import models.Cultivo;
import ui.Menu;
import java.io.IOException;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java App2 cultivos.csv");
            return;
        }
        String archivo = args[0];
        try {
            List<Cultivo> cultivos = CsvService.leerCultivosDesdeCSV(archivo);
            Menu.mostrarMenu(cultivos);
            CsvService.guardarCultivosEnCSV(cultivos, archivo);
            System.out.println("Cambios guardados en " + archivo);
        } catch (IOException e) {
            System.err.println("Error CSV: " + e.getMessage());
        }
    }
}
