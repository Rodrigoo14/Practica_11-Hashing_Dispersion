package ejercicio02;

public class Book {
	private String title;
    private String author;
    private int sales;
    private int rating;
    private String specialty;
    private String comments;

    public Book(String title, String author, int sales, int rating, String specialty, String comments) {
        this.title = title;
        this.author = author;
        this.sales = sales;
        this.rating = rating;
        this.specialty = specialty;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getSales() {
        return sales;
    }

    public int getRating() {
        return rating;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "LIBRO\nTítulo: " + title +
                "\nAutor: " + author +
                "\nVentas: " + sales +
                "\nCalificación de la crítica: " + rating +
                "\nEspecialidad: " + specialty +
                "\nComentarios: " + comments;
    }
}
