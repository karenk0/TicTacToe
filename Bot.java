package tictactoe;

import static tictactoe.Strategy.MEDIUM;
import static tictactoe.Strategy.WEAK;

public class Bot extends Player {
    protected Strategy level;
    private static int countBot = 0;

    @Override
    public void increase() {
        this.countBot++;
    }

    public Bot(char marker, String name, Strategy level) {
        super(marker, name);
        this.level = level;
        //count++;
    }

    public static int getPlayerCount() {
        return countBot;
    }

    public String getMove(Board board) {
        String move = null;
        if (level == WEAK) {
            move = weak_algorithm(board);

        } else if (level == MEDIUM) {
            move = medium_algorithm(board);
        }
        return move;
    }

    public String weak_algorithm(Board board) {
        String move = null;
        board.printBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.gameBoard[i][j] == '\u0000') {
                    move = String.valueOf(i) + String.valueOf(j);
                    return move;
                }
            }
        }
        return move;
    }

    public String medium_algorithm(Board board) {
        String move = null;
        board.printBoard();
        int marker_count;
        for (int i = 0; i < 3; i++) {
            marker_count = 0;
            for (int j = 0; j < 3; j++) { // checking rows
                if (board.gameBoard[i][j] == this.marker) {
                    marker_count++;
                }
            }
            if (marker_count == 2) {
                for (int j = 0; j < 3; j++) {
                    if (board.gameBoard[i][j] == '\u0000') {
                        move = String.valueOf(i) + String.valueOf(j);
                    }
                }
                return move;
            }
        }

        for (int i = 0; i < 3; i++) {
            marker_count = 0;
            for (int j = 0; j < 3; j++) { // checking columns
                if (board.gameBoard[j][i] == this.marker) {
                    marker_count++;
                }
            }
            if (marker_count == 2) {
                for (int j = 0; j < 3; j++) {
                    if (board.gameBoard[j][j] == '\u0000') {
                        move = String.valueOf(j) + String.valueOf(i);
                    }
                }
                return move;
            }
        }

        marker_count = 0;
        for (int i = 0; i < 3; i++) {
            if (board.gameBoard[i][i] == this.marker) {
                marker_count++;
            }
        }
        if (marker_count == 2) {
            for (int i = 0; i < 3; i++) {
                if (board.gameBoard[i][i] == '\u0000') {
                    move = String.valueOf(i) + String.valueOf(i);
                }
            }
            return move;
        }


        for (int i = 0; i < 3; i++) {
            if (board.gameBoard[i][2 - i] == this.marker) {
                marker_count++;
            }
        }
        if (marker_count == 2) {
            for (int i = 0; i < 3; i++) {
                if (board.gameBoard[i][2 - i] == '\u0000') {
                    move = String.valueOf(i) + String.valueOf(2 - i);
                }
            }
            return move;
        }
        move = weak_algorithm(board);
        return move;
    }
}

