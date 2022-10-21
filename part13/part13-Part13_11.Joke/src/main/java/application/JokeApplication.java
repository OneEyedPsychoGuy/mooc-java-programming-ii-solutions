package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        launch(JokeApplication.class);
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
        final BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);
        layout.setTop(menu);

        final StackPane firstView = createView("What do you call a bear with no teeth?");
        final StackPane secondView = createView("A gummy bear.");
        final StackPane thirdView = createView("Because bears with no teeth only have gums!");

        jokeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.setCenter(firstView);
            }
        });

        answerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.setCenter(secondView);
            }
        });

        explanationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.setCenter(thirdView);
            }
        });

        layout.setCenter(firstView);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }
}