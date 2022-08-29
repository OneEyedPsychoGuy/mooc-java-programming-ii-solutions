import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        while(true) {
            String input = keyboard.nextLine();
            if(input.equals("end")) break;
            inputs.add(input);
        }

        double average = inputs.stream().mapToInt(input -> Integer.valueOf(input)).average().getAsDouble();
        System.out.println("average of the numbers: " + average);

        keyboard.close();
    }
}