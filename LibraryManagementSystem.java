//Project 2: "Simple Library Management System “
//A command-line Java program that allows users to:
//● Add books to a library.
//● Search for books by title.
//● Borrow and return books.
//● Display the available books list.
//● How It Works:
//1. Add Book → Adds books to the library (stored in an array).
//2. Search Book → Searches for a book by title.
//3. Borrow Book → Marks the book as borrowed (if available).
//4. Return Book → Marks the book as returned.
//5. Display Books → Shows the list of available books.
//6. Exit → Ends the program.
package Projects.Jan;
   import java.util.Scanner;
class Book {
    String title;
    String author;
    boolean isBorrowed;
}

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] library = new Book[10]; //Array to store books
        int bookCount = 0; //Number of books in the library

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add Book
                    if (bookCount >= library.length) {
                        System.out.println("Library is full. Cannot add more books.");
                        break;
                    }
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();

                    // Create a new Book object and assign values directly
                    Book newBook = new Book();
                    newBook.title = title;
                    newBook.author = author;
                    newBook.isBorrowed = false;

                    library[bookCount] = newBook;
                    bookCount++;
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    // Search Book
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (library[i].title.equalsIgnoreCase(searchTitle)) {
                            System.out.println("Book found: " + formatBookDetails(library[i]));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    // Borrow Book
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    boolean borrowSuccess = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (library[i].title.equalsIgnoreCase(borrowTitle)) {
                            if (!library[i].isBorrowed) {
                                library[i].isBorrowed = true;
                                System.out.println("Book borrowed successfully!");
                            } else {
                                System.out.println("Book is already borrowed.");
                            }
                            borrowSuccess = true;
                            break;
                        }
                    }
                    if (!borrowSuccess) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    // Return Book
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    boolean returnSuccess = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (library[i].title.equalsIgnoreCase(returnTitle)) {
                            if (library[i].isBorrowed) {
                                library[i].isBorrowed = false;
                                System.out.println("Book returned successfully!");
                            } else {
                                System.out.println("Book was not borrowed.");
                            }
                            returnSuccess = true;
                            break;
                        }
                    }
                    if (!returnSuccess) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    // Display Available Books
                    System.out.println("\nAvailable Books:");
                    boolean availableBooks = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (!library[i].isBorrowed) {
                            System.out.println(formatBookDetails(library[i]));
                            availableBooks = true;
                        }
                    }
                    if (!availableBooks) {
                        System.out.println("No books available.");
                    }
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method to format book details
    private static String formatBookDetails(Book book) {
        String status = book.isBorrowed ? "Borrowed" : "Available";
        return "Title: " + book.title + ", Author: " + book.author + ", Status: " + status;
    }
}
