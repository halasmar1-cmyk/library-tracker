import java.util.ArrayList;

public class LibraryTracker {

    static ArrayList<String> books = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Library Tracker!");
        addBook("Java Basics");
        listBooks();
    }

    public static void addBook(String title) {
        books.add(title);
    }

    public static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books in the library:");
            for (String book : books) {
                System.out.println("- " + book);
            }
        }
    }
}