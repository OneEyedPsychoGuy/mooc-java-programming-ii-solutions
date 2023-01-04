package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {
    public static void main(String[] args) {
        Application.launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage window) {
        Label label = new Label("Label");
        Button button = new Button("Button");

        FlowPane pane = new FlowPane();
        pane.getChildren().add(label);
        pane.getChildren().add(button);

        window.setScene(new Scene(pane));
        window.show();
    }
}