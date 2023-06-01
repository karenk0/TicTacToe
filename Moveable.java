package tictactoe;
public interface Moveable {
    static int getPlayerCount() {
        return Player.count;
    }

    public abstract void increase();

    char getMarker();

    String getName();

    String getMove(Board board);
}
