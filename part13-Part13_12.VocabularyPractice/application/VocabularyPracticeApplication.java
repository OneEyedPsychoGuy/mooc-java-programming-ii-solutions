package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

public class VocabularyPracticeApplication extends Application {
    private Dictionary dictionary;

    public static void main(String[] args) {
        Application.launch(VocabularyPracticeApplication.class);
    }

    @Override
    public void init() {
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage window) {
        PracticeView practiceView = new PracticeView(this.dictionary);
        InputView inputView = new InputView(dictionary);

        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        enterButton.setOnAction(event -> layout.setCenter(inputView.getView()));
        practiceButton.setOnAction(event -> layout.setCenter(practiceView.getView()));

        menu.getChildren().addAll(enterButton, practiceButton);
        layout.setTop(menu);
        layout.setCenter(inputView.getView());

        window.setScene(new Scene(layout, 400, 300));
        window.show();
    }
}