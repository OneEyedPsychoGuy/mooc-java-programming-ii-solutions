package FlightControl.ui;

import FlightControl.domain.Airplane;
import FlightControl.logic.FlightControl;

import java.util.Scanner;

public class TextUI {
    private FlightControl controller;
    private Scanner scanner;

    public TextUI(FlightControl controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void start() {
        startAssetConsole();
        startFlightConsole();
    }

    private void startAssetConsole() {
        System.out.println(
            "Airport Asset Control\n" +
            "--------------------\n"
        );

        while(true) {
            System.out.println(
                "Choose an action:\n" +
                "[1] Add an airplane\n" +
                "[2] Add a flight\n" +
                "[x] Exit Airport Asset Control"
            );

            System.out.print("> ");
            String command = this.scanner.nextLine();

            if(command.equals("1")) {
                addAirplane();
            } else if(command.equals("2")) {
                addFlight();
            } else if(command.equals("x")) {
                break;
            }
        }
    }

    private void startFlightConsole() {
        System.out.println(
            "Flight Control\n" +
            "------------\n"
        );

        while(true) {
            System.out.println(
                "Choose an action:\n" +
                "[1] Print airplanes\n" +
                "[2] Print flights\n" +
                "[3] Print airplane details\n" +
                "[x] Quit"
            );

            System.out.print("> ");
            String command = this.scanner.nextLine();

            if(command.equals("1")) {
                printAirplanes();
            } else if(command.equals("2")) {
                printFlights();
            } else if(command.equals("3")) {
                printAirplaneDetails();
            } else if(command.equals("x")) {
                break;
            }
        }
    }

    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.valueOf(this.scanner.nextLine());

        this.controller.addAirplane(id, capacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.print("Give the departure airport id: ");
        String departure = this.scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destination = this.scanner.nextLine();

        this.controller.addFlight(plane, departure, destination);
    }

    private Airplane askForAirplane() {
        Airplane plane = null;
        while(plane == null) {
            String id = this.scanner.nextLine();
            plane = this.controller.getAirplane(id);

            if(plane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }

        return plane;
    }

    private void printAirplanes() {
        this.controller.getAirplanes().forEach(System.out::println);
    }

    private void printFlights() {
        this.controller.getFlights().forEach(flight -> System.out.println(flight + "\n"));
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.println(plane + "\n");
    }
}