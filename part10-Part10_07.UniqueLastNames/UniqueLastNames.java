import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UniqueLastNames {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Continue personal information input? \"quit\" ends:");
            String answer = "quit";
            if(scanner.hasNextLine()) answer = scanner.nextLine();
            if(answer.equals("quit")) break;

            System.out.print("Input first name: ");
            String firstName = "";
            if(scanner.hasNextLine()) firstName = scanner.nextLine();

            System.out.print("Input last name: ");
            String lastName = "";
            if(scanner.hasNextLine()) lastName = scanner.nextLine();

            System.out.print("Input the year of birth: ");
            int birthYear = 0;
            if(scanner.hasNextLine()) birthYear = Integer.valueOf(scanner.nextLine());

            persons.add(new Person(firstName, lastName, birthYear));
            System.out.println();
        }
        scanner.close();
        
        System.out.println("Unique last names in alphabetical order:");
        persons.stream()
            .map(person -> person.getLastName())
            .distinct()
            .sorted()
            .forEach(System.out::println);
    }
}