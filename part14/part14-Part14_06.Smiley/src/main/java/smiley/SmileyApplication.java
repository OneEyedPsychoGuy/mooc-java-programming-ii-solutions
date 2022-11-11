package smiley;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SmileyApplication extends Application {
    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    private void drawSmiley(GraphicsContext painter) {
        painter.fillRect(120, 60, 60, 60);
        painter.fillRect(300, 60, 60, 60);
        painter.fillRect(60, 240, 60, 60);
        painter.fillRect(120, 300, 60, 60);
        painter.fillRect(180, 300, 60, 60);
        painter.fillRect(240, 300, 60, 60);
        painter.fillRect(300, 300, 60, 60);
        painter.fillRect(360, 240, 60, 60);
    }

    @Override
    public void start(Stage window) {
        Canvas canvas = new Canvas(640, 480);
        final GraphicsContext painter = canvas.getGraphicsContext2D();
        final ColorPicker palette = new ColorPicker();

        BorderPane layout = new BorderPane();
        layout.setCenter(canvas);
        layout.setRight(palette);

        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                painter.setFill(palette.getValue());
                painter.fillOval(event.getX(), event.getY(), 4, 4);
            }
        });

        this.drawSmiley(painter);

        window.setScene(new Scene(layout));
        window.show();
    }
}