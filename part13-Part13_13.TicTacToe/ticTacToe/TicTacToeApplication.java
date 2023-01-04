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
        Application.launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window) {
        TicTacToeBoard board = new TicTacToeBoard();

        Label turn = new Label("Turn: X");
        turn.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 40));

        GridPane grid = new GridPane();
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                final int i = row;
                final int j = col;

                Button btn = new Button(" ");
                btn.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 40));
                btn.setOnAction(event -> {
                    if(board.isEnded()) return;

                    if(btn.getText().equals(" ")) {
                        char letter = turn.getText().split(" ")[1].charAt(0);
                        btn.setText(letter + "");
                        board.add(letter, i, j);

                        if(letter == 'O') {
                            turn.setText("Turn: X");
                        } else {
                            turn.setText("Turn: O");
                        }
                    }

                    if(board.isEnded()) turn.setText("The end!");
                });

                grid.add(btn, row, col);
            }
        }

        BorderPane layout = new BorderPane();
        layout.setTop(turn);
        layout.setCenter(grid);

        window.setScene(new Scene(layout));
        window.show();
    }
}