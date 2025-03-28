package digitalLibrary;
import java.util.*;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // View all books
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(book -> System.out.println(book));
        }
    }

    // Search a book by ID or Title
    public Book searchBook(String searchTerm) {
        for (Book book : books) {
            if (book.getBookID().equalsIgnoreCase(searchTerm) || book.getTitle().equalsIgnoreCase(searchTerm)) {
                return book;
            }
        }
        return null;
    }

    // Update a book's details
    public boolean updateBook(String bookID, String newTitle, String newAuthor, String newGenre, String newAvailabilityStatus) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setGenre(newGenre);
                book.setAvailabilityStatus(newAvailabilityStatus);
                return true;
            }
        }
        return false;
    }

    // Delete a book by ID
    public boolean deleteBook(String bookID) {
        return books.removeIf(book -> book.getBookID().equals(bookID));
    }
}
