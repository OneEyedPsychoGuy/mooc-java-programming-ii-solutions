import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BooksFromFile { 
    public static void main(String[] args) {

    }

    public static List<Book> readBooks(String file) {
        try {
            return Files.lines(Paths.get(file))
                .map(line -> line.split(","))
                .filter(data -> data.length == 4)
                .map(data -> new Book(data[0], Integer.valueOf(data[1]), Integer.valueOf(data[2]), data[3]))
                .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}