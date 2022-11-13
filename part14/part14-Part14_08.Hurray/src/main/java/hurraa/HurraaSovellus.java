package hurraa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {
    public static void main(String[] args) {
        launch(HurraaSovellus.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button button = new Button("Hurray!");
        pane.setCenter(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new AudioClip("file:Applause-Yannick_Lemieux.wav").play();
            }
        });

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }
}