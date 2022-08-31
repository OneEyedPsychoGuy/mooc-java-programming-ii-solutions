import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        while(true) {
            String input = keyboard.nextLine();
            if(input.equals("")) break;
            inputs.add(input);
        }

        inputs.forEach(System.out::println);
        keyboard.close();
    }
}