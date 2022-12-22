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
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) {
        final TextField textField = new TextField();
        final Label label = new Label();
        Button button = new Button("Update");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText(textField.getText());
            }
        });

        VBox notifier = new VBox();
        notifier.getChildren().addAll(textField, button, label);

        window.setScene(new Scene(notifier));
        window.show();
    }
}