import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BooksFromFile { 
    public static List<Book> readBooks(String file) {
        try {
            return Files.lines(Paths.get(file))
                .map(line -> line.split(","))
                .filter(parts -> parts.length == 4)
                .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
                .collect(Collectors.toList());
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}