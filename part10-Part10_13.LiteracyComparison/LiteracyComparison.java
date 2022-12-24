import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LiteracyComparison {
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                .map(line -> line.split(","))
                .map(parts -> new Literacy(parts[0], parts[1], parts[2].replace("(%)", "").trim(), parts[3], Integer.valueOf(parts[4]), Double.valueOf(parts[5])))
                .sorted()
                .forEach(System.out::println);
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}