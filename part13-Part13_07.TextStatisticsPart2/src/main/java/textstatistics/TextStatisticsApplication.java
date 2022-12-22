package textstatistics;

import java.util.Arrays;
import java.util.Comparator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TextStatisticsApplication extends Application {
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) {
        TextArea textArea = new TextArea();
        final Label letterCount = new Label("Letters: 0");
        final Label wordCount = new Label("Words: 0");
        final Label longest = new Label("The longest word is: ");

        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> change, String oldValue, String newValue) {
                String[] words = newValue.split(" ");

                String longestWord = Arrays.stream(words).sorted(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s2.length() - s1.length();
                    }
                }).findFirst().get();

                letterCount.setText("Letters: " + newValue.length());
                wordCount.setText("Words: " + words.length);
                longest.setText("The longest word is: " + longestWord);
            }
        });

        HBox statistics = new HBox();
        statistics.setSpacing(10);
        statistics.getChildren().add(letterCount);
        statistics.getChildren().add(wordCount);
        statistics.getChildren().add(longest);

        BorderPane pane = new BorderPane();
        pane.setCenter(textArea);
        pane.setBottom(statistics);

        window.setScene(new Scene(pane));

        window.show();
    }
}