package ticTacToe;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TicTacToeApplication extends Application {
    private static final String FONT_FAMILY = "Monospaced";

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window) {
        Label turn = new Label("Turn: X");
        turn.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 40));

        GridPane board = new GridPane();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Button btn = new Button(" ");
                btn.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 40));
                board.add(btn, i, j);
            }
        }

        BorderPane layout = new BorderPane();
        layout.setTop(turn);
        layout.setCenter(board);

        window.setScene(new Scene(layout));
        window.show();
    }
}