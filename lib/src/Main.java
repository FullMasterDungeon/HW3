import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.fillLibrary();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input your name");
            String name = scanner.nextLine();
            Reader reader = new Reader(name);
            String i = scanner.nextLine();
            switch (i) {
                case "/get": {
                    String a = scanner.nextLine();
                    lib.oweBook(a, reader);
                }
                case "/put": {
                    String a = scanner.nextLine();
                    lib.returnBook(a, reader);
                }
                case "/ask": {
                    String a = scanner.nextLine();
                    lib.askIfPresent(a);
                }
                case "/all": {
                    lib.getKeys();
                }
                case "/leave":{
                    System.exit(1);
                }
            }
        }
    }
}