import java.util.Scanner;

public class LiquidContainers {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int first = 0, second = 0;

        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = keyboard.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if(amount < 0) {
                continue;
            }

            switch(command) {
                case "add":
                    first += amount;
                    if(first > 100) {
                        first = 100;
                    }
                    break;
                default:
                    System.out.println("Unknown command");
            }

            System.out.println();
        }

        keyboard.close();
    }
}