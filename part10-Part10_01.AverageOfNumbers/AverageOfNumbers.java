import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String input = scanner.nextLine();
            if(input.equals("end")) break;
            inputs.add(input);
        }
        scanner.close();

        System.out.println("average of the numbers: " + inputs.stream().mapToInt(i -> Integer.valueOf(i)).average().getAsDouble());
    }
}