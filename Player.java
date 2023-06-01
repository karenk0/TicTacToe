package tictactoe;

import java.util.Scanner;

public class Player implements Moveable {
    protected static int count = 0;
    protected char marker;
    protected String name;

    public Player() {
        this.marker = 'X';
        this.name = "Player";
        increase();
        /*
        if(!(this instanceof Bot)){ //checks if the object is not a instance of Bot, to avoid adding not exicting players in count
            count++;
        }
         */
    }

    public Player(char marker, String name) {
        this.marker = marker;
        this.name = name;
        increase();
        /*
        if(!(this instanceof Bot)){
            count++;
        }
        */
    }

    @Override
    public void increase(){
        count++;
    }

    @Override
    public char getMarker() {
        return marker;
    }
    @Override
    public String getName(){return name;}

    public static int getPlayerCount() {
        return count;
    }

    @Override
    public boolean equals (Object player){
        if(!(player instanceof Player)){
            return false;
        }
        if (this == player){
            return true;

        }
        Player castedPlayer = (Player) player;
        if(castedPlayer.name.equals(this.name) && castedPlayer.marker == this.marker){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "name = " + this.name + ", marker = " + this.marker;
    }
    @Override
    public String getMove(Board board) {
        //TODO: implement
        // Prints the board, asks from the player to make a move, returns the move
        board.printBoard();
        System.out.println("Make a move:\n");
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine();
        return move;
    }
}

