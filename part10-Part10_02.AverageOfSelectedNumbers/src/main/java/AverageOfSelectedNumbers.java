import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        
        while(true) {
            String input = keyboard.nextLine();
            if(input.equals("end")) break;

            inputs.add(input);
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String answer = keyboard.nextLine();

        if(answer.equals("n")) {
            double negativeAverage = inputs.stream()
                .mapToInt(input -> Integer.valueOf(input))
                .filter(num -> num < 0)
                .average()
                .getAsDouble();
            System.out.println("Average of the negative numbers: " + negativeAverage);
        } else {
            double positiveAverage = inputs.stream()
                .mapToInt(input -> Integer.valueOf(input))
                .filter(num -> num > 0)
                .average()
                .getAsDouble();
            System.out.println("Average of the positive numbers: " + positiveAverage);
        }

        keyboard.close();
    }
}
