package ejercicio02;

import java.util.Comparator;

public class SalesComparator implements Comparator<Book> {
	
    public int compare(Book book1, Book book2) {
        return Integer.compare(book2.getSales(), book1.getSales());
    }
}