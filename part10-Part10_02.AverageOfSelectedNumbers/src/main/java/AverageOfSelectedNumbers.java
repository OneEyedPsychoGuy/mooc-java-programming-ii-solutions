import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("end")) break;
            inputs.add(input);
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String answer = scanner.nextLine();
        scanner.close();

        if(answer.equals("n")) {
            double negAvg = inputs.stream()
                .mapToInt(i -> Integer.valueOf(i))
                .filter(num -> num < 0)
                .average()
                .getAsDouble();
            
            System.out.println("Average of the negative numbers: " + negAvg);
        } else {
            double posAvg = inputs.stream()
                .mapToInt(i -> Integer.valueOf(i))
                .filter(num -> num > 0)
                .average()
                .getAsDouble();
            
            System.out.println("Average of the positive numbers: " + posAvg);
        }
    }
}