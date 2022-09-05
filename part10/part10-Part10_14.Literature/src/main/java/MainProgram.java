import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        while(true) {
            System.out.print("Input the name of the book, empty stops: ");
            String title = keyboard.nextLine();

            if(title.isEmpty()) break;

            System.out.print("Input the age recommendation: ");
            int recommendedAge = Integer.valueOf(keyboard.nextLine());

            books.add(new Book(title, recommendedAge));
            System.out.println();
        }

        System.out.println("\n" + books.size() + " books in total.\n");
        System.out.println("Books:");
        Collections.sort(books, Comparator.comparing(Book::getRecommnededAge));
        books.forEach(System.out::println);

        keyboard.close();
    }
}