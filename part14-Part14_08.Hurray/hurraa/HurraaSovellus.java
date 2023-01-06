package hurraa;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {
    public static void main(String[] args) {
        Application.launch(HurraaSovellus.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AudioClip sound = new AudioClip("file:Applause-Yannick_Lemieux.wav");
        BorderPane pane = new BorderPane();
        Button button = new Button("Hurray!");

        button.setOnAction(event -> sound.play());
        pane.setCenter(button);

        stage.setScene(new Scene(pane, 600, 400));
        stage.show();
    }
}