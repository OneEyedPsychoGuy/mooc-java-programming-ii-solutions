package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MultipleViews extends Application {
    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(final Stage window) {
        Label firstViewLabel = new Label("First view!");
        Button firstViewButton = new Button("To the second view!");

        BorderPane firstViewBorder = new BorderPane();
        firstViewBorder.setTop(firstViewLabel);
        firstViewBorder.setCenter(firstViewButton);

        final Scene firstScene = new Scene(firstViewBorder);

        Label secondViewLabel = new Label("Second view!");
        Button secondViewButton = new Button("To the third view!");

        VBox secondViewVBox = new VBox();
        secondViewVBox.getChildren().addAll(secondViewButton, secondViewLabel);

        final Scene secondScene = new Scene(secondViewVBox);

        Label thirdViewLabel = new Label("Third view!");
        Button thirdViewButton = new Button("To the first view!");

        GridPane thirdViewGrid = new GridPane();
        thirdViewGrid.add(thirdViewLabel, 0, 0);
        thirdViewGrid.add(thirdViewButton, 1, 1);

        final Scene thirdScene = new Scene(thirdViewGrid);

        firstViewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent handle) {
                window.setScene(secondScene);
            }
        });

        secondViewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent handle) {
                window.setScene(thirdScene);
            }
        });

        thirdViewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent handle) {
                window.setScene(firstScene);
            }
        });

        window.setScene(firstScene);
        window.show();
    }
}