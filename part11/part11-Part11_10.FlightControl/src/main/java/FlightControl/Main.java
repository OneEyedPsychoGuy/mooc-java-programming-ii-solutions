package FlightControl;

import java.util.Scanner;
import FlightControl.logic.FlightControl;
import FlightControl.ui.TextUI;

public class Main {
    public static void main(String[] args) {
        TextUI ui = new TextUI(new FlightControl(), new Scanner(System.in));
        ui.start();
    }
}