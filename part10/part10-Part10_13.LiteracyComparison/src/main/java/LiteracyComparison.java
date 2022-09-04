import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LiteracyComparison {
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .map(data -> new Literacy(data[0], data[1], data[2].replace("(%)", "").trim(), data[3], Integer.valueOf(data[4]), Double.valueOf(data[5])))
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}