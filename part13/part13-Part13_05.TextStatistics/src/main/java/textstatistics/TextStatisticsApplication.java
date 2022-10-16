package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) {
        BorderPane pane = new BorderPane();

        HBox statistics = new HBox();
        statistics.setSpacing(10);
        statistics.getChildren().add(new Label("Letters: 0"));
        statistics.getChildren().add(new Label("Words: 0"));
        statistics.getChildren().add(new Label("The longest word is:"));

        pane.setCenter(new TextArea());
        pane.setBottom(statistics);

        window.setScene(new Scene(pane));
        window.show();
    }
}