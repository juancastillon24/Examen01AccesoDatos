import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ServicioFiltradoPeliculas implements DataService {

    @Override
    public List<Pelicula> findAll() {
        var salida = new ArrayList<Pelicula>();

        String archivo = "peliculas.csv";
        try (var br = new BufferedReader(new FileReader(new File(archivo)))) {
            var contenido = br.lines();

            contenido.forEach(line -> {
                String[] lineArray = line.split(",");
                Pelicula pelicula = new Pelicula();
                pelicula.setId(Integer.parseInt(lineArray[0]));
                pelicula.setTitulo(lineArray[1]);
                pelicula.setAño(Integer.parseInt(lineArray[2]));
                pelicula.setDirector(lineArray[3]);
                pelicula.setGenero(lineArray[4]);

            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }

    public void filtrarPorGenero(String genero) {
        File fileGenero = new File(genero + ".csv");
        try {
            List<String> lineas = Files.readAllLines(Path.of("peliculas.csv"));
            for (String linea : lineas) {

                String[] items = (linea.trim()).split(",");
                String Genero = items[4];

                if (Genero.equals(genero)) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileGenero))) {
                        writer.write(linea);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void filtrarPorDirector(String director) {
        File fileDirector = new File(director + ".csv");
        try {
            List<String> lineas = Files.readAllLines(Path.of("peliculas.csv"));
            for (String linea : lineas) {

                String[] items = (linea.trim()).split(",");
                String Director = items[3];

                if (Director.equals(director)) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileDirector))) {
                        writer.write(linea);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
