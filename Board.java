package tictactoe;

public class Board {

    protected char[][] gameBoard;

    public Board() {
        gameBoard = new char[3][3];
    }


    void printBoard() {
        System.out.println(this);
    }

    boolean submitMove(String move, char player){
        //TODO: implement
        // Puts the player marker on the board if move is valid
        // move consists of 2 digits representing the row and column, like "12" (first row, second column)
        // if it is an invalid move then false is returned
        char[] coordinates = move.toCharArray(); //converts string to char
        if(coordinates.length == 2){
            int row = Character.getNumericValue(coordinates[0]); //convert char to int
            int column = Character.getNumericValue(coordinates[1]); //convert char to int

            if(gameBoard[row][column] == '\u0000'){
                gameBoard[row][column] = player;
                return true;
            }
        }
        return false;
    }

    boolean isBoardFull() {
        //TODO: implement
        // Checks whether the board is full
        int free_fields = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(gameBoard[i][j] == '\u0000'){
                    free_fields++;
                }
            }
        }
        if (free_fields != 0) {
            return false;
        }
        return true;
    }

    boolean isWinner(char player) {
        //TODO: implement
        // Checks whether 'X' or 'O' is a winner

        int marker_count;
        for (int i = 0; i < 3; i++) {
            marker_count = 0;
            for (int j = 0; j < 3; j++) { // checking rows
                if (gameBoard[i][j] == player) {
                    marker_count++;
                }
            }
            if (marker_count == 3) {
                return true;
            }
        }


        for (int k = 0; k < 3; k++) {
            marker_count = 0;
            for (int j = 0; j < 3; j++) { //checking columns
                if (gameBoard[j][k] == player) {
                    marker_count++;
                }
            }
            if (marker_count == 3) {
                return true;
            }
        }


        //checking diagonal
        if (    (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) ||
                (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player)){
            return true;
        }

        return false;
    }


    public String toString(){
        //coverts the board to string like:
        /*      X | O | X
                -----------
                O | X | O
                -----------
                O | X | X*/
        return " " +
                gameBoard[0][0] + " | " +
                gameBoard[0][1] + " | " +
                gameBoard[0][2] +
                "\n-----------\n" +
                " " +
                gameBoard[1][0] + " | " +
                gameBoard[1][1] + " | " +
                gameBoard[1][2] +
                "\n-----------\n" +
                " " +
                gameBoard[2][0] + " | " +
                gameBoard[2][1] + " | " +
                gameBoard[2][2];
    }

}
