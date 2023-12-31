import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {
    public static List<String> read(String file) {
        try {
            return Files.lines(Paths.get(file)).collect(Collectors.toList());
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}