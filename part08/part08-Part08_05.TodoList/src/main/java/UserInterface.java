import java.util.Scanner;

public class UserInterface {
    private TodoList todoList;
    private Scanner scanner;

    public UserInterface(TodoList todoList, Scanner scanner) {
        this.todoList = todoList;
        this.scanner = scanner;
    }

    public void start() {
        String command = "";

        do {
            System.out.print("Command: ");
            command = this.scanner.nextLine();
            this.processCommand(command);
        } while(!command.equals("stop"));
    }

    private void processCommand(String command) {
        switch(command) {
            case "add":
                this.add();
                break;
            case "list":
                this.list();
                break;
            case "remove":
                this.remove();
                break;
            case "stop":
                break;
            default:
                System.out.println("Unknown command");
        }
    }

    private void add() {
        System.out.print("To add: ");
        this.todoList.add(this.scanner.nextLine());
    }

    private void list() {
        this.todoList.print();
    }

    private void remove() {
        System.out.print("Which one is removed? ");
        this.todoList.remove(Integer.valueOf(this.scanner.nextLine()));
    }
}