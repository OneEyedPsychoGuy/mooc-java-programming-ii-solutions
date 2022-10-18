package title;

import java.util.Scanner;

import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Write a title: ");
        String title = keyboard.nextLine();

        Application.launch(UserTitle.class,
            "--title=" + title);

        keyboard.close();
    }
}