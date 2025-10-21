import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Pelicula {
    private Integer id;
    private String titulo;
    private Integer año;
    private String director;
    private String genero;
}
