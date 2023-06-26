package ejercicio02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookStore {
    private Map<String, Book> books;

    public BookStore() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        String title = book.getTitle();
        books.put(title, book);
        System.out.println("El libro ha sido agregado correctamente.");
    }

    public void modifyBook(Book book) {
        String title = book.getTitle();
        if (books.containsKey(title)) {
            books.put(title, book);
            System.out.println("El libro ha sido modificado correctamente.");
        } else {
            System.out.println("El libro no existe en la colección. Por favor, agregue el libro usando la opción 'agregar'.");
        }
    }

    public Book findBestBookByAuthor(String author) {
        Book bestBook = null;
        int maxRating = Integer.MIN_VALUE;
        for (Book book : books.values()) {
            if (book.getAuthor().equals(author) && book.getRating() > maxRating) {
                bestBook = book;
                maxRating = book.getRating();
            }
        }
        return bestBook;
    }

    public List<Book> getBooksBySpecialty(String specialty) {
        List<Book> booksBySpecialty = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getSpecialty().equals(specialty)) {
                booksBySpecialty.add(book);
            }
        }
        Collections.sort(booksBySpecialty, new SalesComparator());
        return booksBySpecialty;
    }

    public void printBooksBySales() {
        List<Book> sortedBooks = new ArrayList<>(books.values());
        Collections.sort(sortedBooks, new SalesComparator());
        for (Book book : sortedBooks) {
            System.out.println(book);
        }
    }

    public void printMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Agregar libro");
            System.out.println("2. Modificar libro");
            System.out.println("3. Compra segura");
            System.out.println("4. Listado de libros por especialidad");
            System.out.println("5. Listado de libros por ventas");
            System.out.println("6. Salir");
            System.out.print("Ingrese el número de opción deseada: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea después de leer el número de opción

            switch (option) {
                case 1:
                    addBookFromUserInput(scanner);
                    break;
                case 2:
                    modifyBookFromUserInput(scanner);
                    break;
                case 3:
                    findBestBookByAuthorFromUserInput(scanner);
                    break;
                case 4:
                    getBooksBySpecialtyFromUserInput(scanner);
                    break;
                case 5:
                    printBooksBySales();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número válido.");
            }
        }
    }

    private void addBookFromUserInput(Scanner scanner) {
        System.out.println("\n----- AGREGAR LIBRO -----");
        System.out.print("Ingrese el título del libro: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String author = scanner.nextLine();
        System.out.print("Ingrese el número de ventas del libro: ");
        int sales = scanner.nextInt();
        System.out.print("Ingrese la calificación de la crítica del libro: ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume el salto de línea después de leer el número de calificación
        System.out.print("Ingrese la especialidad del libro: ");
        String specialty = scanner.nextLine();
        System.out.print("Ingrese los comentarios del libro: ");
        String comments = scanner.nextLine();

        Book book = new Book(title, author, sales, rating, specialty, comments);
        addBook(book);
    }

    private void modifyBookFromUserInput(Scanner scanner) {
        System.out.println("\n----- MODIFICAR LIBRO -----");
        System.out.print("Ingrese el título del libro a modificar: ");
        String title = scanner.nextLine();

        if (books.containsKey(title)) {
            Book existingBook = books.get(title);
            System.out.println("Libro encontrado: " + existingBook);
            System.out.println("Ingrese la nueva información del libro:");

            System.out.print("Nuevo título: ");
            String newTitle = scanner.nextLine();
            System.out.print("Nuevo autor: ");
            String newAuthor = scanner.nextLine();
            System.out.print("Nuevo número de ventas: ");
            int newSales = scanner.nextInt();
            System.out.print("Nueva calificación de la crítica: ");
            int newRating = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea después de leer el número de calificación
            System.out.print("Nueva especialidad: ");
            String newSpecialty = scanner.nextLine();
            System.out.print("Nuevos comentarios: ");
            String newComments = scanner.nextLine();

            Book newBook = new Book(newTitle, newAuthor, newSales, newRating, newSpecialty, newComments);
            modifyBook(newBook);
        } else {
            System.out.println("El libro no existe en la colección. Por favor, agregue el libro usando la opción 'agregar'.");
        }
    }

    private void findBestBookByAuthorFromUserInput(Scanner scanner) {
        System.out.println("\n----- COMPRA SEGURA -----");
        System.out.print("Ingrese el autor: ");
        String author = scanner.nextLine();

        Book bestBook = findBestBookByAuthor(author);

        if (bestBook != null) {
            System.out.println("El libro con mejor crítica del autor '" + author + "' es:");
            System.out.println(bestBook);
        } else {
            System.out.println("No se encontraron libros del autor '" + author + "'.");
        }
    }

    private void getBooksBySpecialtyFromUserInput(Scanner scanner) {
        System.out.println("\n----- LISTADO DE LIBROS POR ESPECIALIDAD -----");
        System.out.print("Ingrese la especialidad: ");
        String specialty = scanner.nextLine();

        List<Book> books = getBooksBySpecialty(specialty);

        if (!books.isEmpty()) {
            System.out.println("Libros de la especialidad '" + specialty + "' ordenados por ventas:");
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("No se encontraron libros de la especialidad '" + specialty + "'.");
        }
    }

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.printMenu();
    }
}