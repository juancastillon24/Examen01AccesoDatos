
public class Main {

    public static void main(String[] args) {
        var pelicula = (new ServicioFiltradoPeliculas());
        pelicula.filtrarPorGenero("Terror");
        pelicula.filtrarPorDirector("Steven Spielberg");
    }
}
