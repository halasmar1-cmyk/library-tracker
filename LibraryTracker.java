import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
public class LibraryTracker {

    static ArrayList<String> books = new ArrayList<>();
    static final Path BOOKS_FILE = Path.of("books.json");

    public static void main(String[] args) {
        System.out.println("Welcome to Library Tracker!");
        loadBooks();
        listBooks();
    }

    public static void addBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            printBanner();
            return;
        }

        books.add(title);
        saveBooks();
        System.out.println("Book added successfully: " + title);
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
    public static void saveBooks() {
    try {
        ArrayList<String> jsonBooks = new ArrayList<>();

        for (String book : books) {
            String escaped = book.replace("\\", "\\\\")
                                 .replace("\"", "\\\"")
                                 .replace("\n", "\\n")
                                 .replace("\r", "\\r")
                                 .replace("\t", "\\t");
            jsonBooks.add("\"" + escaped + "\"");
        }

        String json = "[" + String.join(",", jsonBooks) + "]";
        Files.writeString(BOOKS_FILE, json);

        System.out.println("Books saved successfully.");
    } catch (IOException e) {
        System.out.println("Error saving books: " + e.getMessage());
     }
   }
   public static void loadBooks() {
    try {
        if (!Files.exists(BOOKS_FILE)) {
            return;
        }

        String json = Files.readString(BOOKS_FILE).trim();

        books.clear();

        if (json.equals("[]")) {
            return;
        }

        if (!json.startsWith("[") || !json.endsWith("]")) {
            System.out.println("Invalid books.json format.");
            return;
        }

        String content = json.substring(1, json.length() - 1);

        java.util.regex.Matcher matcher =
            java.util.regex.Pattern.compile(
                "\"((?:\\\\.|[^\"\\\\])*)\""
            ).matcher(content);

        while (matcher.find()) {
            String book = matcher.group(1)
                    .replace("\\n", "\n")
                    .replace("\\r", "\r")
                    .replace("\\t", "\t")
                    .replace("\\\"", "\"")
                    .replace("\\\\", "\\");

            books.add(book);
        }

        System.out.println("Books loaded successfully.");

    } catch (IOException e) {
        System.out.println("Error loading books: " + e.getMessage());
    }
  }
  
  public static void printBanner() {
    System.out.println("=== Welcome to Library Tracker - Student B ===");
}

}