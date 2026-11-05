import java.util.ArrayList;

public class LibraryTracker {

    static ArrayList<String> books = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Library Tracker!");
        addBook("Java Basics");
        System.out.println(books);
    }

    public static void addBook(String title) {
        books.add(title);
    }
}