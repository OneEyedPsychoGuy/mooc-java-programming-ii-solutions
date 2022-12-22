package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

public class VocabularyPracticeApplication extends Application {
    private Dictionary dictionary;

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

    @Override
    public void init() {
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage window) {
        final PracticeView practiceView = new PracticeView(this.dictionary);
        final InputView inputView = new InputView(dictionary);

        final BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        menu.getChildren().addAll(enterButton, practiceButton);
        layout.setTop(menu);

        enterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.setCenter(inputView.getView());
            }
        });

        practiceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                layout.setCenter(practiceView.getView());
            }
        });

        layout.setCenter(inputView.getView());

        Scene view = new Scene(layout, 400, 300);

        window.setScene(view);
        window.show();
    }
}