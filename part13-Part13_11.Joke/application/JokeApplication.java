package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class JokeApplication extends Application {
    public static void main(String[] args) {
        Application.launch(JokeApplication.class);
    }

    private StackPane createView(String text) {
        StackPane layout = new StackPane();

        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    @Override
    public void start(Stage window) {        
        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);
        layout.setTop(menu);

        StackPane joke = createView("What do you call a bear with no teeth?");
        StackPane answer = createView("A gummy bear.");
        StackPane explanation = createView("Because bears with no teeth only have gums!");

        jokeButton.setOnAction(event -> layout.setCenter(joke));
        answerButton.setOnAction(event -> layout.setCenter(answer));
        explanationButton.setOnAction(event -> layout.setCenter(explanation));

        layout.setCenter(joke);

        window.setScene(new Scene(layout));
        window.show();
    }
}