package digitalLibrary;
import java.util.Scanner;

public class LibraryManager {

    private Library library;
    private Scanner scanner;

    public LibraryManager() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    // Show the main menu
    public void displayMenu() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID or Title");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    library.viewAllBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Add a book
    private void addBook() {
        System.out.print("Enter Book ID: ");
        String bookID = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability Status (Available/Checked Out): ");
        String availabilityStatus = scanner.nextLine();

        // Create a new book and add to the library
        Book newBook = new Book(bookID, title, author, genre, availabilityStatus);
        library.addBook(newBook);
        System.out.println("Book added successfully.");
    }

    // Search for a book by ID or Title
    private void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        String searchTerm = scanner.nextLine();

        Book book = library.searchBook(searchTerm);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Update a book's details
    private void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String bookID = scanner.nextLine();
        System.out.print("Enter New Title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter New Author: ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter New Genre: ");
        String newGenre = scanner.nextLine();
        System.out.print("Enter New Availability Status (Available/Checked Out): ");
        String newAvailabilityStatus = scanner.nextLine();

        boolean updated = library.updateBook(bookID, newTitle, newAuthor, newGenre, newAvailabilityStatus);
        if (updated) {
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Delete a book
    private void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String bookID = scanner.nextLine();

        boolean deleted = library.deleteBook(bookID);
        if (deleted) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}
