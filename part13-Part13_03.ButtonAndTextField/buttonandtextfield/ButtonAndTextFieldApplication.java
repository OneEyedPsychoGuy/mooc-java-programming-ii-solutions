package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {
    public static void main(String[] args) {
        Application.launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage window) {
        Button button = new Button("Button");
        TextField text = new TextField();

        FlowPane pane = new FlowPane();
        pane.getChildren().add(button);
        pane.getChildren().add(text);

        window.setScene(new Scene(pane));
        window.show();
    }
}