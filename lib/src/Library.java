import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Library {
    private HashMap<String, Book> books;
    private HashMap<String, Book> rentedBooks;

    public Library() {
        books = new HashMap<>();
        rentedBooks = new HashMap<>();
    }

    public void getKeys() {
        if (!books.isEmpty()) {
            for (String key : books.keySet()) {
                System.out.println(key);
            }
        }
    }

    public void oweBook(String name, Reader person) {
        if (books.containsKey(name)) {
            rentedBooks.put(name, books.get(name));
            person.addBook(books.get(name));
            books.remove(name);
        } else {
            System.out.println("The " + name + " is missing");
        }
    }

    public void askIfPresent(String name) {
        if (books.containsKey(name)) {
            System.out.println("The " + name + " is present in the library");
        } else if (rentedBooks.containsKey(name)) {
            System.out.println("The " + name + " is missing, but will be soon");
        } else {
            System.out.println("The " + name + " is missing");
        }
    }

    public void returnBook(String name, Reader person) {
        if (rentedBooks.containsKey(name)) {
            books.put(name, rentedBooks.get(name));
            rentedBooks.remove(name);
            person.removeBook(name);
        }
    }

    public void fillLibrary() {
        try {
            FileReader file = new FileReader("books.txt");
            BufferedReader reader = new BufferedReader(file);
            String line = reader.readLine();
            while (line != null) {
                String[] splitLine = line.split(";");
                this.books.put(splitLine[0], new Book(splitLine[0], splitLine[1], splitLine[2], Integer.parseInt(splitLine[3])));
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
