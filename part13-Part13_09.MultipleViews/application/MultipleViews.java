package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MultipleViews extends Application {
    public static void main(String[] args) {
        Application.launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) {
        Label firstViewLabel = new Label("First view!");
        Button firstViewButton = new Button("To the second view!");
        BorderPane firstViewBorder = new BorderPane();
        firstViewBorder.setTop(firstViewLabel);
        firstViewBorder.setCenter(firstViewButton);
        Scene firstScene = new Scene(firstViewBorder);

        Label secondViewLabel = new Label("Second view!");
        Button secondViewButton = new Button("To the third view!");
        VBox secondViewVBox = new VBox();
        secondViewVBox.getChildren().addAll(secondViewButton, secondViewLabel);
        Scene secondScene = new Scene(secondViewVBox);

        Label thirdViewLabel = new Label("Third view!");
        Button thirdViewButton = new Button("To the first view!");
        GridPane thirdViewGrid = new GridPane();
        thirdViewGrid.add(thirdViewLabel, 0, 0);
        thirdViewGrid.add(thirdViewButton, 1, 1);
        Scene thirdScene = new Scene(thirdViewGrid);

        firstViewButton.setOnAction(event -> window.setScene(secondScene));
        secondViewButton.setOnAction(event -> window.setScene(thirdScene));
        thirdViewButton.setOnAction(event -> window.setScene(firstScene));

        window.setScene(firstScene);
        window.show();
    }
}