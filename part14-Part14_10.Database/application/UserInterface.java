package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while(true) {
            this.menu();
            String command = this.scanner.nextLine();
            if(command.equals("x")) break;

            this.processCommand(command);
        }
        System.out.println("Thank you!");
    }

    private void menu() {
        System.out.println("\n" +
            "Enter command:\n" +
            "1) list\n" +
            "2) add\n" +
            "3) mark as done\n" +
            "4) remove\n" +
            "x) quit"
        );
        System.out.print("> ");
    }

    public void processCommand(String command) throws SQLException {
        switch(command) {
            case "1":
                this.list();
                break;
            case "2":
                this.add();
                break;
            case "3":
                this.markAsDone();
                break;
            case "4":
                this.remove();
                break;
            default:
                System.out.println("Unknown command");
        }
    }

    public void list() throws SQLException {
        System.out.println("Listing the database contents");
        System.out.println(this.database.list());
    }

    public void add() throws SQLException {
        System.out.println("Adding a new todo");

        System.out.println("Enter name");
        String name = this.scanner.nextLine();
        System.out.println("Enter description");
        String description = this.scanner.nextLine();

        this.database.add(new Todo(name, description, false));
    }

    public void markAsDone() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        this.database.markAsDone(Integer.valueOf(this.scanner.nextLine()));
    }

    public void remove() throws SQLException {
        System.out.println("Which todo should be removed as (give the id)?");
        this.database.remove(Integer.valueOf(this.scanner.nextLine()));
    }
}