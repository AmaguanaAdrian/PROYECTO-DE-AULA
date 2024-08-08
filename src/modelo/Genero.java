package modelo;

/**
 *
 * @author 
 */
public class Genero {
    private int id;
    private String nombreGenero;

    public Genero() {
    }

    public Genero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    // Agregamos el constructor con ID
    public Genero(int id, String nombreGenero) {
        this.id = id;
        this.nombreGenero = nombreGenero;
    }

    public int getId() {
        return id;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
}

