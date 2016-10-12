package Domain;

/**
 * Created by rony- on 10/9/2016.
 */
public class Comentario {
    private String titulo;
    private String texto;
    private int rating;

    public Comentario(String titulo, String texto, int rating){
        this.titulo=titulo;
        this.texto=texto;
        this.rating=rating;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
