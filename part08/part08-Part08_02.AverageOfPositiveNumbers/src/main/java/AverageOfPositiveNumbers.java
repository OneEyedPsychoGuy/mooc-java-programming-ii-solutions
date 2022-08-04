import java.util.Scanner;

public class AverageOfPositiveNumbers {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int count = 0, sum = 0;

        while(true) {
            int num = Integer.valueOf(keyboard.nextLine());
            
            if(num == 0) {
                break;
            } else if(num > 0) {
                count++;
                sum += num;
            }
        }

        if(count != 0) {
            System.out.println(1.0 * sum / count);
        } else {
            System.out.println("Cannot calculate the average");
        }

        keyboard.close();
    }
}