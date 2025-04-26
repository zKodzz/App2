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

public class CsvService {

    public static List<Cultivo> leerCultivosDesdeCSV(String ruta) throws IOException {
        List<Cultivo> cultivos = new ArrayList<>();
        List<String> lineas = Files.readAllLines(Paths.get(ruta));

        String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

        for (String linea : lineas) {
            if (!linea.trim().startsWith("Cultivo")) continue;
            String[] partes = linea.split(regex, -1);

            String nombre      = partes[1].replace("\"", "");
            String variedad    = partes[2].replace("\"", "");
            double superficie  = Double.parseDouble(partes[3]);
            String parcela     = partes[4].replace("\"", "");
            LocalDate fecha    = LocalDate.parse(partes[5].replace("\"", ""));
            String estado      = partes[6].replace("\"", "");

            Cultivo cultivo = new Cultivo(nombre, variedad, superficie, parcela, fecha, estado);

            String actividadesRaw = Arrays.stream(partes)
                    .skip(7)
                    .collect(Collectors.joining(","))
                    .trim();

            if (actividadesRaw.startsWith("[")) actividadesRaw = actividadesRaw.substring(1);
            if (actividadesRaw.endsWith("]"))   actividadesRaw = actividadesRaw.substring(0, actividadesRaw.length() - 1);

            Pattern p = Pattern.compile("\"([^\"]+)\"");
            Matcher m = p.matcher(actividadesRaw);
            while (m.find()) {
                String[] datos = m.group(1).split(":");
                if (datos.length == 2) {
                    String tipo = datos[0];
                    LocalDate fAct = LocalDate.parse(datos[1]);
                    cultivo.agregarActividad(new Actividad(tipo, fAct));
                }
            }

            cultivos.add(cultivo);
        }

        return cultivos;
    }

    public static void guardarCultivosEnCSV(List<Cultivo> cultivos, String ruta) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(Paths.get(ruta))) {
            for (Cultivo c : cultivos) {
                String actividades = c.getActividades().stream()
                    .map(Actividad::toString)
                    .map(s -> "\"" + s + "\"")
                    .collect(Collectors.joining(","));
                String linea = String.format(
                    "Cultivo,\"%s\",\"%s\",%.1f,\"%s\",\"%s\",\"%s\",[%s]",
                    c.getNombre(), c.getVariedad(), c.getSuperficie(),
                    c.getCodigoParcela(), c.getFechaSiembra(), c.getEstado(), actividades
                );
                w.write(linea);
                w.newLine();
            }
        }
    }
}
