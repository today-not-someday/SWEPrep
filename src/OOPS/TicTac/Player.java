package OOPS.TicTac;


public abstract class Player {

    private int player;
    private Move move;

    public Player(int player) {
        this.player = player;
    }

    public abstract void getPosition(Board board);

    public void move(Board board) {
        board.setPostion(move,player);
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public int getPlayer() {
        return this.player;
    }
}
