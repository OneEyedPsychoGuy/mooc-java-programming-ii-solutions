import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        System.out.println("How many random numbers should be printed?");
        int quantity = Integer.valueOf(keyboard.nextLine());
        
        while(quantity > 0) {
            System.out.println(random.nextInt(11));
            quantity--;
        }

        keyboard.close();
    }
}