import java.util.Scanner;

public class Cubes {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while(true) {
            String input = keyboard.nextLine();
            if(input.equals("end")) {
                break;
            }

            System.out.println((int) Math.pow(Integer.valueOf(input), 3));
        }

        keyboard.close();
    }
}