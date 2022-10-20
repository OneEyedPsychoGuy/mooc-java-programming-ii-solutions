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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GreeterApplication extends Application {
    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(final Stage window) {
        Label instructionLabel = new Label("Enter your name and start.");
        final TextField nameEntryTextField = new TextField();
        Button startButton = new Button("Start");

        GridPane nameEntryLayout = new GridPane();

        nameEntryLayout.add(instructionLabel, 0, 0);
        nameEntryLayout.add(nameEntryTextField, 0, 1);
        nameEntryLayout.add(startButton, 0, 2);

        nameEntryLayout.setPrefSize(300, 180);
        nameEntryLayout.setAlignment(Pos.CENTER);
        nameEntryLayout.setVgap(10);
        nameEntryLayout.setHgap(10);
        nameEntryLayout.setPadding(new Insets(20, 20, 20, 20));

        Scene nameEntryView = new Scene(nameEntryLayout);

        final Label welcomeText = new Label("Welcome!");

        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);

        final Scene welcomeView = new Scene(welcomeLayout);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                welcomeText.setText("Welcome " + nameEntryTextField.getText() + "!");
                window.setScene(welcomeView);
            }
        });

        window.setScene(nameEntryView);
        window.show();
    }
}