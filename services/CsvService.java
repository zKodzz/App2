package services;

import models.Cultivo;
import models.Actividad;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// Clase que proporciona servicios para leer y guardar cultivos en formato CSV
public class CsvService {

    // Método que lee cultivos desde un archivo CSV y devuelve una lista de objetos Cultivo
    public static List<Cultivo> leerCultivosDesdeCSV(String ruta) throws IOException {
        List<Cultivo> cultivos = new ArrayList<>(); // Lista para almacenar los cultivos leídos
        List<String> lineas = Files.readAllLines(Paths.get(ruta)); // Lee todas las líneas del archivo CSV

        // Expresión regular para dividir las líneas en partes, considerando comillas
        String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

        // Itera sobre cada línea del archivo
        for (String linea : lineas) {
            // Ignora líneas que no comienzan con "Cultivo"
            if (!linea.trim().startsWith("Cultivo")) continue;

            // Divide la línea en partes usando la expresión regular
            String[] partes = linea.split(regex, -1);

            // Extrae los datos del cultivo de las partes
            String nombre      = partes[1].replace("\"", ""); // Nombre del cultivo
            String variedad    = partes[2].replace("\"", ""); // Variedad del cultivo
            double superficie  = Double.parseDouble(partes[3]); // Superficie del cultivo
            String parcela     = partes[4].replace("\"", ""); // Código de la parcela
            LocalDate fecha    = LocalDate.parse(partes[5].replace("\"", "")); // Fecha de siembra
            String estado      = partes[6].replace("\"", ""); // Estado del cultivo

            // Crea un nuevo objeto Cultivo con los datos extraídos
            Cultivo cultivo = new Cultivo(nombre, variedad, superficie, parcela, fecha, estado);

            // Extrae las actividades en formato crudo desde las partes restantes
            String actividadesRaw = Arrays.stream(partes)
                    .skip(7) // Salta las primeras 7 partes que ya se han procesado
                    .collect(Collectors.joining(","))
                    .trim();

            // Elimina los corchetes de inicio y fin si están presentes
            if (actividadesRaw.startsWith("[")) actividadesRaw = actividadesRaw.substring(1);
            if (actividadesRaw.endsWith("]"))   actividadesRaw = actividadesRaw.substring(0, actividadesRaw.length() - 1);

            // Utiliza una expresión regular para encontrar las actividades en el formato "tipo:fecha"
            Pattern p = Pattern.compile("\"([^\"]+)\"");
            Matcher m = p.matcher(actividadesRaw);
            while (m.find()) {
                String[] datos = m.group(1).split(":"); // Divide cada actividad en tipo y fecha
                if (datos.length == 2) {
                    String tipo = datos[0]; // Tipo de actividad
                    LocalDate fAct = LocalDate.parse(datos[1]); // Fecha de la actividad
                    // Agrega la actividad al cultivo
                    cultivo.agregarActividad(new Actividad(tipo, fAct));
                }
            }

            // Agrega el cultivo a la lista de cultivos
            cultivos.add(cultivo);
        }

        return cultivos; // Devuelve la lista de cultivos leídos
    }

    // Método que guarda una lista de cultivos en un archivo CSV
    public static void guardarCultivosEnCSV(List<Cultivo> cultivos, String ruta) throws IOException {
        // Utiliza un BufferedWriter para escribir en el archivo CSV
        try (BufferedWriter w = Files.newBufferedWriter(Paths.get(ruta))) {
            // Itera sobre cada cultivo en la lista
            for (Cultivo c : cultivos) {
                // Convierte la lista de actividades a una cadena en formato CSV
                String actividades = c.getActividades().stream()
                    .map(Actividad::toString) // Convierte cada actividad a su representación en cadena
                    .map(s -> "\"" + s + "\"") // Agrega comillas alrededor de cada actividad
                    .collect(Collectors.joining(",")); // Une las actividades en una sola cadena

                // Formatea la línea CSV para el cultivo
                String linea = String.format(
                    "Cultivo,\"%s\",\"%s\",%.1f,\"%s\",\"%s\",\"%s\",[%s]",
                    c.getNombre(), c.getVariedad(), c.getSuperficie(),
                    c.getCodigoParcela(), c.getFechaSiembra(), c.getEstado(), actividades
                );

                
        }
    }
}
