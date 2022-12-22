import java.util.HashMap;

public class Program {
    public static void printValues(HashMap<String, Book> map) {
        for(Book book : map.values()) {
            System.out.println(book);
        }
    }

    public static void printValueIfNameContains(HashMap<String, Book> map, String text) {
        for(Book book : map.values()) {
            if(book.getName().contains(text)) {
                System.out.println(book);
            }
        }
    }
}