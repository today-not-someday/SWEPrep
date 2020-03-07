package OOPS.TicTacToe;

public class Board {


    private final int size;
    private boolean isWinner;

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public Board(int size) {
        this.size = size;
        rows = new int[size];
        cols = new int[size];
        this.isWinner = false;


    }


    public void setPostion(Move move, int player) {

        // Update Board position
    }

    public int getSize() {
        return size;
    }
}
