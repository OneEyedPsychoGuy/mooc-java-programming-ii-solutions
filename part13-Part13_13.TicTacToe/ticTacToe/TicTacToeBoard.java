package ticTacToe;

public class TicTacToeBoard {
    private char[][] board;

    public TicTacToeBoard() {
        char[][] array = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        this.board = array;
    }

    public void add(char letter, int row, int col) {
        if(!(letter == 'X' || letter == 'O')) {
            throw new IllegalArgumentException("Letter needs to be X or O!");
        }

        this.board[row][col] = letter;
    }

    public boolean isEnded() {
        return this.isFull() || this.checkRows() || this.checkColumns() || this.checkDiagonals();
    }

    private boolean isFull() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                if(!(this.board[row][col] == 'X' || this.board[row][col] == 'O')) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRows() {
        for(int row = 0; row < 3; row++) {
            if(this.board[row][0] == this.board[row][1] && 
                this.board[row][1] == this.board[row][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for(int col = 0; col < 3; col++) {
            if(this.board[0][col] == this.board[1][col] && 
                this.board[1][col] == this.board[2][col]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        boolean forwardDiagonal = this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2];
        boolean backwardDiagonal = this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0];
        return forwardDiagonal || backwardDiagonal;
    }
}