import java.util.Arrays;
import java.util.Comparator;
public class Driver6 {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(5);

        library.addBook(new Book(1, "ABC", "J.D. Salinger"));
        library.addBook(new Book(2, "JKL", "Harper Lee"));
        library.addBook(new Book(3, "GHI", "George Orwell"));
        library.addBook(new Book(4, "DEF", "Jane Austen"));
        library.addBook(new Book(5, "MNO", "F. Scott Fitzgerald"));

        // Perform linear search
        System.out.println("Linear Search:");
        Book book = library.linearSearchByTitle("GHI");
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }

        // Sort books by title for binary search
        Arrays.sort(library.getBooks(), 0, library.getSize(), Comparator.comparing(Book::getTitle));

        // Perform binary search
        System.out.println("Binary Search:");
        book = library.binarySearchByTitle("MNO");
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}
