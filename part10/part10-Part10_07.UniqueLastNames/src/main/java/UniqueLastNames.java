import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UniqueLastNames {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Continue personal information input? \"quit\" ends:");
            String continueQ = "quit";
            if(keyboard.hasNextLine()){
                continueQ = keyboard.nextLine();
            }

            if (continueQ.equals("quit")) {
                break;
            }

            System.out.print("Input first name: ");
            String firstName = "NaN";
            if(keyboard.hasNextLine()) {
                firstName = keyboard.nextLine();
            }

            System.out.print("Input last name: ");
            String lastName = "NaN";
            if(keyboard.hasNextLine()) {
                lastName = keyboard.nextLine();
            }

            System.out.print("Input the year of birth: ");
            int birthYear = 0;
            if(keyboard.hasNextLine()) {
                birthYear = Integer.valueOf(keyboard.nextLine());
            }

            persons.add(new Person(firstName, lastName, birthYear));
            System.out.println("");
        }
        
        System.out.println("Unique last names in alphabetical order:");
        persons.stream()
            .map(person -> person.getLastName())
            .distinct()
            .sorted()
            .forEach(System.out::println);

        keyboard.close();
    }
}