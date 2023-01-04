package notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class NotifierApplication extends Application {
    public static void main(String[] args) {
        Application.launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) {
        TextField text = new TextField();
        Label label = new Label();
        Button button = new Button("Update");

        button.setOnAction(event -> label.setText(text.getText()));

        VBox notifier = new VBox();
        notifier.getChildren().addAll(text, button, label);

        window.setScene(new Scene(notifier));
        window.show();
    }
}