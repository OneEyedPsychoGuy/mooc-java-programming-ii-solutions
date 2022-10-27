package ticTacToe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        final TicTacToeBoard board = new TicTacToeBoard();

        final Label turn = new Label("Turn: X");
        turn.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 40));

        final GridPane grid = new GridPane();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                final Button btn = new Button(" ");
                btn.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, 40));

                final int row = i;
                final int col = j;

                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(board.isEndGame()) {
                            return;
                        }

                        if(btn.getText().equals(" ")) {
                            char letter = turn.getText().split(" ")[1].charAt(0);
                            btn.setText(letter + "");
                            board.add(letter, row, col);

                            if(letter == 'O') {
                                turn.setText("Turn: X");
                            } else {
                                turn.setText("Turn: O");
                            }
                        }

                        if(board.isEndGame()) {
                            turn.setText("The end!");
                        }
                    }
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