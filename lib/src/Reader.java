import java.util.HashMap;

public class Reader {
    private String name;
    private HashMap<String, Book> books;
    public Reader(String name){
        this.name = name;
        books = new HashMap<>();
    }
    public void addBook(Book book){
        books.put(book.name, book);
    }
    public void removeBook(String name){
        if(books.containsKey(name)){
            books.remove(name);
        }else {
            System.out.println("Reader doesn't have such book");
        }
    }
}
