package tictactoe;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;

    public Game() {
        this.player1 = new Player();
        this.player2 = new Player('O',"Player");
        this.board = new Board();
    }

    public Game(Board board){
        this.player1 = new Player();
        this.player2 = new Player('O',"Player");
        this.board = board;
    }

    public Game(Board board, Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String playGame() {
        //TODO: implement
        // Plays the game:
        // 1. Prints the board
        // 2. Asks from a current player to make a move
        // 3. Submits the move, if the move was submitted then continues from point 1 the same thing for the other player,
        //    if the move was not submitted (invalid move) then prints appropriate message and asks to make a move again from the same player
        // Keeps doing the above steps until one of the players wins, or the board gets full and no one wins
        // At the end this method should print the final result of the board and return the marker of the winner or the word "Tie" if no one wins
        int queue = 1;
        String move;
        boolean submit_move;
        while(!board.isBoardFull()){
            if(queue == 1){
                move = player1.getMove(board);
                submit_move = board.submitMove(move,player1.getMarker());
                if(!submit_move){
                    System.out.println("Invalid move, try again:\n");
                    queue = 1;
                }
                else{
                    queue = 2;
                }
                if(board.isWinner(player1.getMarker())){
                    break;
                }
            }
            else if(board.isBoardFull()){
                break;
            }
            else {
                move = player2.getMove(board);
                submit_move = board.submitMove(move,player2.getMarker());
                if(!submit_move){
                    System.out.println("Invalid move, try again:\n");
                    queue = 2;
                }
                else{
                    queue = 1;
                }
                if(board.isWinner(player2.getMarker())){
                    break;
                }
            }
        }
        board.printBoard();
        return getResult();
    }

    private String getResult(){
        //TODO: implement
        // returns the result of the game: the marker of the winner or the word "Tie"
        if(board.isWinner(player1.getMarker())){
            return "" + player1.toString();
        }
        if(board.isWinner(player2.getMarker())){
            return "" + player2.toString();
        }
        return "Tie";
    }
}
