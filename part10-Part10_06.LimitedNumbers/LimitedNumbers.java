import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int num = Integer.valueOf(scanner.nextLine());
            if(num < 0) break;
            nums.add(num);
        }

        nums.stream()
            .filter(num -> num >= 1 && num <= 5)
            .forEach(System.out::println);
        
        scanner.close();
    }
}