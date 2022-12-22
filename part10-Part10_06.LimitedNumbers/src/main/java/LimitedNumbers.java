import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        while(true) {
            int number = Integer.valueOf(keyboard.nextLine());
            if(number < 0) break;
            numbers.add(number);
        }

        numbers.stream()
                .filter(num -> num >= 1 && num <= 5)
                .forEach(System.out::println);
        
        keyboard.close();
    }
}
