package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class GreeterApplication extends Application {
    public static void main(String[] args) {
        Application.launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) {
        Label instructionLabel = new Label("Enter your name and start.");
        TextField nameField = new TextField();
        Button startButton = new Button("Start");

        GridPane nameEntryLayout = new GridPane();

        nameEntryLayout.add(instructionLabel, 0, 0);
        nameEntryLayout.add(nameField, 0, 1);
        nameEntryLayout.add(startButton, 0, 2);

        nameEntryLayout.setPrefSize(300, 180);
        nameEntryLayout.setAlignment(Pos.CENTER);
        nameEntryLayout.setVgap(10);
        nameEntryLayout.setHgap(10);
        nameEntryLayout.setPadding(new Insets(20, 20, 20, 20));

        Scene nameEntryView = new Scene(nameEntryLayout);

        Label welcomeText = new Label("Welcome!");

        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene welcomeView = new Scene(welcomeLayout);

        startButton.setOnAction(event -> {
            welcomeText.setText("Welcome " + nameField.getText() + "!");
            window.setScene(welcomeView);
        });

        window.setScene(nameEntryView);
        window.show();
    }
}